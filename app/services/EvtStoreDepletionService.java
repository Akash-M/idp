package services;

import models.EvtStorageDepletionStart;

import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
public interface EvtStoreDepletionService {
    List<EvtStorageDepletionStart> getEvtStoreDepletionStartList();
    List<EvtStorageDepletionStart> getEvtStoreDepletionStartByTime();
}
