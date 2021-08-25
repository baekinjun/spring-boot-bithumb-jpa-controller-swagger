package net.injun.api.order.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import net.injun.api.order.domain.Order;
import net.injun.api.order.service.OrderServiceImpl;
import net.injun.api.user.domain.User;
import net.injun.api.user.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public void save(Order order) {
        orderService.save(order);
    }

    @PutMapping
    public void update(Order order) {
        orderService.save(order);
    }

    @GetMapping("/exits")
    public ResponseEntity<Boolean> existsById(long id) {
        return ResponseEntity.ok(orderService.existsById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(orderService.count());
    }

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        orderService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        orderService.deleteAll();
    }


}
