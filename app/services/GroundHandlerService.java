package services;

import models.GroundHandler;

import models.GroundHandler;

import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
public interface GroundHandlerService {
    List<GroundHandler> getGroundHandlers();
    String getGroundHandlerNameById(Integer id);
}