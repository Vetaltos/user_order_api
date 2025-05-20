package ru.sechko.homework.user_order_api.service;

import org.springframework.stereotype.Service;
import ru.sechko.homework.user_order_api.model.Order;
import ru.sechko.homework.user_order_api.model.User;
import ru.sechko.homework.user_order_api.repository.OrderRepository;
import ru.sechko.homework.user_order_api.repository.UserRepository;

import java.util.List;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;


    public OrderService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ не найден"));
    }

    public Order create(Long userId, Order order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        order.setUser(user);
        return orderRepository.save(order);
    }

    public Order update(Long id, Order order) {
        Order oldOrder = findById(id);
        oldOrder.setProduct(order.getProduct());
        oldOrder.setTotal(order.getTotal());
        oldOrder.setStatus(order.getStatus());
        return orderRepository.save(oldOrder);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}