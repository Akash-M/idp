package controllers;

import models.User;
import play.libs.F;
import play.mvc.*;

import play.mvc.Controller;
import services.UserService;
import views.html.*;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class Application extends Controller {

    @Inject
    private UserService userService;

    public Result home() {
        return ok(views.html.home.render());
    }

    public Result carousel() {
        return ok(views.html.carousel.render());
    }

}
