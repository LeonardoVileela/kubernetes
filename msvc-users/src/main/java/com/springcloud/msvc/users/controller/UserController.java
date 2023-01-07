package com.springcloud.msvc.users.controller;

import com.springcloud.msvc.users.domain.User;
import com.springcloud.msvc.users.mapper.requests.UserPostRequestBody;
import com.springcloud.msvc.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<User>> listAll(Pageable pageable) {
        return new ResponseEntity<>(userService.list(pageable), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
