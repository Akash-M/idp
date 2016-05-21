package services;

import models.Worker;

import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
public interface WorkerService {
    List<Worker> getWorkers();
    int getGroundHandlerId(int workerId);
}
