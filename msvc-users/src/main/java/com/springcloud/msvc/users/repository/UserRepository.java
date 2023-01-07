package com.springcloud.msvc.users.repository;

import com.springcloud.msvc.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
