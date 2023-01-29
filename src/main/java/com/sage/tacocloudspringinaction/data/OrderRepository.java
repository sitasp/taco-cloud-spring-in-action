package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Order;

public interface OrderRepository {

    Order save(Order order);
}
