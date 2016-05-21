package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Carousel;
import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselService {
    void addCarousel(Carousel carousel);
    int getMaxCapacity(int carouselId);
    int getCurrentCapacity(int carouselId);
    List<Carousel> getCarousels();
    Carousel findById(int id);
    int countWorkStations(int carouselId);
    JsonNode getFlightList(int carouselId);
}
