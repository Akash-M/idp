package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.CentralStorage;
import play.libs.Json;
import play.mvc.*;
import services.CentralStorageService;

import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class Application extends Controller {

    /*@Inject
    private UserService userService;

    @Inject
    private UserDAO userRepo;*/

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
