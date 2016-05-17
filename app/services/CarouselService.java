package services;

import models.Carousel;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselService {
    void addCarousel(Carousel carousel);
    int getMaxCapacity(int carouselId);
    int getCurrentCapacity(int carouselId);
    //int getCurrentStatus(int carouselId);
}
