package demo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findById(@Param("id") String id);
}
