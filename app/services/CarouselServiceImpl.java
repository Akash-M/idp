package services;

import daos.CarouselDAO;
import models.Carousel;

import javax.inject.Inject;

/**
 * Created by prate_000 on 16-05-2016.
 */
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
}
