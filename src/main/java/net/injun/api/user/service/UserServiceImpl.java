package net.injun.api.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.injun.api.security.domain.SecurityProvider;
import net.injun.api.security.exception.SecurityRuntimeException;
import net.injun.api.user.domain.Role;
import net.injun.api.user.domain.UserDto;
import net.injun.api.user.repository.UserRepository;
import net.injun.api.user.domain.User;
import net.injun.api.util.Proxy;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends Proxy implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    private final ModelMapper modelMapper;

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

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public String signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            //롤을 여러개 주기 떄문에 리스트로 관리 한다.
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            log.info("user" + user);
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("중복된 ID 입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDto signin(User user) {
        try {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = (passwordEncoder.matches(
                    user.getPassword(),
                    userRepository.findByUsername(user.getUsername()).get().getPassword()))
                    ? provider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password";
            userDto.setToken(token);
            return userDto;

        } catch (Exception e) {
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
