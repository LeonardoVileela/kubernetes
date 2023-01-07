package com.springcloud.msvc.users.service;

import com.springcloud.msvc.users.domain.User;
import com.springcloud.msvc.users.exception.BadRequestException;
import com.springcloud.msvc.users.mapper.mapping.UserMapper;
import com.springcloud.msvc.users.mapper.requests.UserPostRequestBody;
import com.springcloud.msvc.users.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> list(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User save(UserPostRequestBody userPostRequestBody) {
        return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    @Override
    public User findById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(
                () -> new BadRequestException("User not found")
        );
    }

    @Override
    public void delete(UUID uuid) {
        try {
            userRepository.delete(userRepository.findById(uuid).orElseThrow(
                    () -> new BadRequestException("User not found")
            ));
        } catch (Exception e) {
            throw new BadRequestException("sorry, we had a problem please try again later");
        }

    }
}
