package services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import daos.CarouselDAO;
import models.Carousel;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import play.api.mvc.Result;
import play.libs.Json;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Named
public class CarouselServiceImpl implements CarouselService {

    @Inject
    private CarouselDAO carouselDAO;

    @Override
    public void addCarousel(Carousel carousel) {
        carouselDAO.save(carousel);
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

    public int countWorkStations(int id){
        Carousel carousel = carouselDAO.findById(id);
        JsonNode csJson = Json.toJson(carousel);
        ArrayNode arrayNode = (ArrayNode) csJson.get("workingStationsAssigned") ;
        return arrayNode.size();
    }
}

