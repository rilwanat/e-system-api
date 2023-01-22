package app.rbapps.esystemapi.services;

import app.rbapps.esystemapi.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getOrders();

    boolean deleteOrder(Long id);

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);
}
