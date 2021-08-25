package net.injun.api.order.service;

import lombok.RequiredArgsConstructor;
import net.injun.api.order.domain.Order;
import net.injun.api.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order item) {
        orderRepository.save(item);
    }

    @Override
    public boolean existsById(long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
