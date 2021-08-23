package net.injun.api.user.service;

import lombok.RequiredArgsConstructor;
import net.injun.api.user.repository.UserRepository;
import net.injun.api.user.domain.User;
import net.injun.api.util.Proxy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends Proxy implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
