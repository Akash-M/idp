package daos;

import models.Carousel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselDAO extends MongoRepository<Carousel, Integer> {
    Carousel findById(int Id);
}
