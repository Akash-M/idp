package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.*;
import services.CentralStorageService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by prate_000 on 16-05-2016.
 *
 * Add route as follows
 * GET  /centralCapacity      controllers.Application.getCSCapacities(arg: String ?= "")
 */
@Named
public class CSController extends Controller {

    @Autowired
    private CentralStorageService csService;


    public Result getCSCapacities(int id) {
        return ok(csService.getCSCapacities(id).toString());
    }

}