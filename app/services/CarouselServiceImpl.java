package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import daos.CarouselDAO;
import models.Carousel;
import play.Configuration;
import play.Play;
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
    private AppConfig appConfig;

    @Inject
    private CarouselDAO carouselDAO;

    @Override
    public void addCarousel(Carousel carousel) {
        carouselDAO.save(carousel);
    }

    public Carousel findById(Integer carouselId){
        return carouselDAO.findById(carouselId);
    }

    public Integer getMaxCapacity(Integer carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        return carousel.getMaxCapacity();
    }

    public Integer getCurrentCapacity(Integer carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        return carousel.getCurrentCapacity();
    }

    public JsonNode getCarousels(){

        List<Carousel> carousels = carouselDAO.findAll();

        List<ObjectNode> carouselsModifiedList = new ArrayList<ObjectNode>();
        /*Read Config file for Carousel limits*/
        Configuration conf = Play.application().configuration();
        Integer carouselLevelOk = conf.getInt("play.application.carousel.ok");
        Integer carouselLevelWarn = conf.getInt("play.application.carousel.warn");
        for (Iterator<Carousel> carouselPtr = carousels.iterator(); carouselPtr.hasNext();
             ) {
            Carousel singleCarousel = carouselPtr.next();
            Integer currentCarouselCapacity = singleCarousel.getCurrentCapacity();
            Integer maxCarouselCapacity = singleCarousel.getMaxCapacity();
            float currentStatusValue = ((float)currentCarouselCapacity/(float) maxCarouselCapacity) * 100;
            String singleCarouselStatus = "";
            if(currentStatusValue <= carouselLevelOk){
                singleCarouselStatus = "OK";
            }
            else if(currentStatusValue > carouselLevelOk && currentStatusValue < carouselLevelWarn){
                singleCarouselStatus = "WARNING";
            }
            else{
                singleCarouselStatus = "DANGER";
            }
            JsonNode singleCarouselJson = Json.toJson(singleCarousel);
            ObjectNode carouselObjectNodeForMerging = ((ObjectNode)singleCarouselJson );
            carouselObjectNodeForMerging = carouselObjectNodeForMerging.put("carouselStatus", singleCarouselStatus);
            carouselsModifiedList.add(carouselObjectNodeForMerging);
        }

        return Json.toJson(carouselsModifiedList);
    }

    public Integer countWorkStations(Integer carouselId){
        Carousel carousel = carouselDAO.findById(carouselId);
        carousel.getWorkStations();
        JsonNode csJson = Json.toJson(carousel);
        JsonNode workStationsNode = csJson.get("workingStationsAssigned") ;
        return workStationsNode.size();
    }

    public JsonNode getFlightList(Integer carouselId){
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
        Collections.sort(carouselsIds);
        return carouselsIds;
    }

}

