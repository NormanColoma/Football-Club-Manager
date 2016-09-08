package controllers;

import java.util.List;
import javax.inject.Inject;
import models.Team;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;

import play.mvc.BodyParser;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamController extends Controller {

    private final JPAApi jpaApi;

    @Inject
    public TeamController(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getTeams() {
        List<Team> teams = jpaApi.em().createQuery("select t from Team t", Team.class).getResultList();
        return ok(toJson(teams));
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result addTeam() {
        JsonNode json = request().body().asJson();
        Team team = new Team();
        team.name = json.findPath("name").textValue();
        team.about = json.findPath("about").textValue();
        jpaApi.em().persist(team);
        return created(toJson(team)).withHeaders("Location", "http://localhost:9000/api/teams/"+team.id);
    }

    @Transactional
    public Result deleteTeam(Integer id) {
        Team team = jpaApi.em().find(Team.class, id);
        if(team != null){
          jpaApi.em().remove(team);
          Result deleted = status(204, "Deleted response");
          return deleted;
        }
        return notFound();

    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateTeam(Integer id) {
        Team team = jpaApi.em().find(Team.class, id);
        if(team != null){
          JsonNode json = request().body().asJson();
          team.setName(json.findPath("name").textValue());
          team.setAbout(json.findPath("about").textValue());
          Result updated = status(204, "Updated response");
          return updated;
        }
        return notFound();

    }

}
