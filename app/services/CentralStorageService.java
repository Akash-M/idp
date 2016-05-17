package services;

import models.CentralStorage;

import java.util.List;


/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CentralStorageService {
    List<CentralStorage> getCSCapacities();
}
