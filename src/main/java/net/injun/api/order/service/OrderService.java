package net.injun.api.order.service;

import net.injun.api.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(long id);
    void save(Order item);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
}
