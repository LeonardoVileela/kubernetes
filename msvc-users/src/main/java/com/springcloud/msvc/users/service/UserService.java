package com.springcloud.msvc.users.service;

import com.springcloud.msvc.users.domain.User;
import com.springcloud.msvc.users.mapper.requests.UserPostRequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    public Page<User> list(Pageable pageable);

    User save(UserPostRequestBody userPostRequestBody);

    public User findById(UUID uuid);

    public void delete(UUID uuid);
}
