package net.injun.api.item.service;

import net.injun.api.item.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(long id);
    void save(Item item);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    void deleteAll();
}
