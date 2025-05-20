package ru.sechko.homework.user_order_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sechko.homework.user_order_api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
