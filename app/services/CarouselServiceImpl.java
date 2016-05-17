package services;

import daos.CarouselRepository;
import models.Carousel;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.inject.Inject;

/**
 * Created by prate_000 on 16-05-2016.
 */
public class CarouselServiceImpl implements CarouselService {

    @Inject
    private CarouselRepository carouselRepository;

    @Override
    public void addCarousel(Carousel carousel) {
        carouselRepository.save(carousel);
    }

    public int getMaxCapacity(int carouselId){
        Carousel carousel = carouselRepository.findById(carouselId);
        return carousel.getMaxCapacity();
    }

    public int getCurrentCapacity(int carouselId){
        Carousel carousel = carouselRepository.findById(carouselId);
        return carousel.getCurrentCapacity();
    }
}
