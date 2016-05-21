package services;

import daos.GroundHandlerDAO;
import models.GroundHandler;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
@Named
public class GroundHandlerServiceImpl implements GroundHandlerService {

    @Inject
    private GroundHandlerDAO groundHandlerDAO;

    public List<GroundHandler> getGroundHandlers(){
        return groundHandlerDAO.findAll();
    }

    public String getGroundHandlerNameById(int id){
        GroundHandler groundHandler = groundHandlerDAO.findById(id);
        return groundHandler.getName();
    }
}
