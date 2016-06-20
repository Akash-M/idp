package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Carousel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselService {
    void addCarousel(Carousel carousel);
    Integer getMaxCapacity(Integer carouselId);
    Integer getCurrentCapacity(Integer carouselId);
    JsonNode getCarousels();
    Carousel findById(Integer id);
    Integer countWorkStations(Integer carouselId);
    JsonNode getFlightList(Integer carouselId);
    List<Integer> getAllCarouselsId();
}
