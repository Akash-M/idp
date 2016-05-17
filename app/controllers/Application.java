package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.util.JSON;
import models.CentralStorage;
import models.User;
import play.libs.Json;
import play.mvc.*;
import scala.util.parsing.json.JSONObject;
import scala.util.parsing.json.JSONObject$;
import services.CentralStorageService;
import views.html.*;

import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.ResponseWrapper;


@Named
public class Application extends Controller {

    /*@Inject
    private UserService userService;

    @Inject
    private UserRepository userRepo;*/

    @Inject
    private CentralStorageService csService;

   /* public Result index() {
        *//*userService.addUser(new User("Akash", "", "Manjunath"));
        User saeed = userRepo.findByFirstName("Saeed");
        return ok("First Name:" + saeed.getFirstName() +"\nLast Name:" + saeed.getLastName() + "\n");*//*
        return ok(csService.getCSCapacities(1).toString());
    }*/


    public Result index() {
        CentralStorage cs = csService.getCSCapacities(1);
        JsonNode csJson = Json.toJson(cs);
        return ok(csJson);
        /*return ok("Awesome");*/
    }

}
