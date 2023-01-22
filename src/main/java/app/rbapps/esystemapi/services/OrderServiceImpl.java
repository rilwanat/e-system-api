package app.rbapps.esystemapi.services;

import app.rbapps.esystemapi.entity.OrderEntity;
import app.rbapps.esystemapi.model.Order;
import app.rbapps.esystemapi.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(order, orderEntity);
        orderRepository.save(orderEntity);

        return order;
    }

    @Override
    public List<Order> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<Order> orders = orderEntities
                .stream()
                .map(emp -> new Order(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId(),
                        emp.getJobInfo(),
                        emp.getFileUrl()
                        )).collect(Collectors.toList());
        return orders;
    }

    @Override
    public boolean deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id).get();
        orderRepository.delete(order);
        return true;
    }

    @Override
    public Order getOrderById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        Order order = new Order();

        BeanUtils.copyProperties(orderEntity, order);
        return order;
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        orderEntity.setFirstName(order.getFirstName());
        orderEntity.setLastName(order.getLastName());
        orderEntity.setEmailId(order.getEmailId());
        orderEntity.setJobInfo(order.getJobInfo());
        orderEntity.setFileUrl(order.getFileUrl());

        orderRepository.save(orderEntity);
        return order;
    }
}
