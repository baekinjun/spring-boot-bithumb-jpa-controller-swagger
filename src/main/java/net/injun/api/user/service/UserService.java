package net.injun.api.user.service;

import net.injun.api.user.domain.User;
import net.injun.api.user.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAll();

    Optional<User> findById(long id);

    void save(User user);

    boolean existsById(long id);

    long count();

    void deleteById(long id);

    void deleteAll();

    String signup(User user);

    UserDto signin(User user);

}
