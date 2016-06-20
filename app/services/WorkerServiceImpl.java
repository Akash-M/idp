package services;

import daos.WorkerDAO;
import models.Worker;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
@Named
public class WorkerServiceImpl implements WorkerService {

    @Inject
    private WorkerDAO workerDAO;

    public List<Worker> getWorkers(){
        return workerDAO.findAll();
    }
    public int getGroundHandlerId(Integer workerId){
        Worker worker =  workerDAO.findById(workerId);
        return worker.getGroundHandler_id();
    }
}
