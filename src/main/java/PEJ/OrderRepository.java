package PEJ;

import feign.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{

    Optional<Order> findByOrderId(@Param("orderId") Long orderId);

}