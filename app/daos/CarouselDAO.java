package daos;

import models.Carousel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselDAO extends MongoRepository<Carousel, Integer> {
    Carousel findById(int Id);
    List<Carousel> findAll();
}
