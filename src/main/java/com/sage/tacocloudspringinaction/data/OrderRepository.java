package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
