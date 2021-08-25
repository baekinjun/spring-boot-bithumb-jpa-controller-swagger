package net.injun.api.user.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import net.injun.api.user.domain.User;
import net.injun.api.user.domain.UserDto;
import net.injun.api.user.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "users")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowCredentials = "*")
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "something wrong"),
            @ApiResponse(code = 403, message = "승인거절"),
            @ApiResponse(code = 422, message = "중복된 username")})
    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                         @RequestBody UserDto userDto) {
        //modelmapper = json으로 받게된다!
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "something wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디/비밀번호")})
    public ResponseEntity<UserDto> signin(@ApiParam("Signin User")
                                         @RequestBody UserDto userDto) {
        //modelmapper = json으로 받게된다!
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public void save(User user) {
        userService.save(user);
    }

    @PutMapping
    public void update(User user) {
        userService.save(user);
    }

    @GetMapping("/exits")
    public ResponseEntity<Boolean> existsById(long id) {
        return ResponseEntity.ok(userService.existsById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(userService.count());
    }

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }


}
