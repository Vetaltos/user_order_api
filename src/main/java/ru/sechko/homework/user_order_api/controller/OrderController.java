package ru.sechko.homework.user_order_api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.sechko.homework.user_order_api.model.Order;
import ru.sechko.homework.user_order_api.service.OrderService;
import ru.sechko.homework.user_order_api.view.Views;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @JsonView(Views.OrderSummary.class)
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.OrderDetails.class)
    public Order getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping("/user/{userId}")
    @JsonView(Views.OrderSummary.class)
    public Order create(@PathVariable Long userId, @Valid @RequestBody Order order) {
        return orderService.create(userId, order);
    }

    @PutMapping("/{id}")
    @JsonView(Views.OrderSummary.class)
    public Order update(@PathVariable Long id, @Valid @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.delete(id);
    }
}
