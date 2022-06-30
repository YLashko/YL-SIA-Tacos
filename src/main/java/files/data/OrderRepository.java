package files.data;

import org.springframework.data.repository.CrudRepository;

import files.Order;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
