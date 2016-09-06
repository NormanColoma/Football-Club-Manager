package controllers;

import models.Team;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

public class TeamController extends Controller {

    private final FormFactory formFactory;

    private final JPAApi jpaApi;

    @Inject
    public TeamController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getTeams() {
        List<Team> teams = jpaApi.em().createQuery("select t from Team t", Team.class).getResultList();
        return ok(toJson(teams));
    }

}
