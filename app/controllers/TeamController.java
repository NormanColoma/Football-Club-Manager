package controllers;

import java.util.List;
import javax.inject.Inject;
import models.Team;
import models.TeamDAOImpl;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import static play.libs.Json.toJson;
import play.mvc.BodyParser;
import com.fasterxml.jackson.databind.JsonNode;
import services.*;

public class TeamController extends Controller {


    private TeamService teamService;
    public TeamController(){
      this.teamService = new TeamService();
    }

    @Transactional(readOnly = true)
    public Result getTeams() {
        List<Team> teams = teamService.getAll();
        return ok(toJson(teams));
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result addTeam() {
        JsonNode json = request().body().asJson();
        Team team = new Team();
        team.name = json.findPath("name").textValue();
        team.about = json.findPath("about").textValue();
        team = teamService.addTeam(team);
        return created(toJson(team)).withHeaders("Location", "http://localhost:9000/api/teams/"+team.id);
    }

    @Transactional
    public Result deleteTeam(Integer id) {
        if(teamService.deleteTeam(id)){
          Result deleted = status(204, "Deleted response");
          return deleted;
        }
        return notFound();
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateTeam(Integer id) {
        Team team = new Team();
        JsonNode json = request().body().asJson();
        team.name = json.findPath("name").textValue();
        team.about = json.findPath("about").textValue();
        if(teamService.updateTeam(team,id)){
          Result updated = status(204, "Updated response");
          return updated;
        }
        return notFound();

    }

}
