package daos;

import com.fasterxml.jackson.databind.JsonNode;
import models.Carousel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CarouselDAO extends MongoRepository<Carousel, Integer>{
    Carousel findById(Integer Id);
    List<Carousel> findAll();

    //List<Carousel> find(Query newQuery, Class);

}
