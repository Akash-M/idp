package services;

import daos.CentralStorageDAO;
import models.CentralStorage;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Named
public class CentralStorageServiceImpl implements CentralStorageService {

    @Inject
    private CentralStorageDAO csRepo;

    @Override
    public List<CentralStorage> getCSCapacities(){
        List<CentralStorage> cs = csRepo.findAll();
        return cs;
    }

}
