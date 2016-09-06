package controllers;

import play.mvc.*;
import play.libs.Json.*;
import play.libs.Json;
import javax.inject.Inject;

import static play.libs.Json.toJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.db.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private Database db;

    @Inject
    public HomeController(Database db) {
        this.db = db;
    }

    public Result index() {
        JsonNode json = Json.parse("{\"firstName\":\"Foo\", \"lastName\":\"Bar\", \"age\":13}");
        return ok(json);
    }

}
