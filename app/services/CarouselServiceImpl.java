package services;

import com.fasterxml.jackson.databind.JsonNode;
import daos.CarouselDAO;
import models.Carousel;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import play.libs.Json;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

import configs.AppConfig;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Named
public class CarouselServiceImpl implements CarouselService {

    @Inject
    private MongoTemplate mongoTemplate;

    @Inject
    private CarouselDAO carouselDAO;

    @Override
    public void addCarousel(Carousel carousel) {
        carouselDAO.save(carousel);
    }

    public Carousel findById(int carouselId){
        return carouselDAO.findById(carouselId);
    }

    public int getMaxCapacity(int carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        return carousel.getMaxCapacity();
    }

    public int getCurrentCapacity(int carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        return carousel.getCurrentCapacity();
    }

    public List<Carousel> getCarousels(){
        return carouselDAO.findAll();
    }

    public int countWorkStations(int carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        carousel.getWorkingStationsAssigned();
        JsonNode csJson = Json.toJson(carousel);
        JsonNode workStationsNode = csJson.get("workingStationsAssigned") ;
        return workStationsNode.size();
    }

    public JsonNode getFlightList(int carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        JsonNode csJson = Json.toJson(carousel);
        JsonNode flightsNode = csJson.get("flight_id") ;
        return flightsNode;
    }

    @Override
    public List<Integer> getAllCarouselsId(){
        List<Carousel> carousels = carouselDAO.findAll();
        List<Integer> carouselsIds = new ArrayList<Integer>();
        for (Iterator<Carousel> i = carousels.iterator(); i.hasNext();) {
            carouselsIds.add(i.next().getId());
        }
        return carouselsIds;
    }

}

