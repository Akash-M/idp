package services;

import daos.EvtStoreDepletionStartDAO;
import models.EvtStorageDepletionStart;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 12-06-2016.
 */
@Named
public class EvtStoreDepletionServiceImpl implements EvtStoreDepletionService {

    @Inject
    private EvtStoreDepletionStartDAO evtStoreDepletionStartDAO;

    @Override
    public List<EvtStorageDepletionStart> getEvtStoreDepletionStartList() {
        return evtStoreDepletionStartDAO.findAll();
    }

    @Override
    public List<EvtStorageDepletionStart> getEvtStoreDepletionStartByTime(Integer time) {
        return evtStoreDepletionStartDAO.findByTime(time);
    }

    @Override
    public List<EvtStorageDepletionStart> getEvtStoreDepletionStartByFlightId(Integer flight_id) {
        return evtStoreDepletionStartDAO.findByFlightId(flight_id);
    }
}
