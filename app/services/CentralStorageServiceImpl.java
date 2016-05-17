package services;

import daos.CentralStorageDAO;
import models.CentralStorage;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Named
public class CentralStorageServiceImpl implements CentralStorageService {

    @Inject
    private CentralStorageDAO csRepo;

    @Override
    public CentralStorage getCSCapacities(Integer id){
        CentralStorage cs = csRepo.findById(id);
        return cs;
    }

}
