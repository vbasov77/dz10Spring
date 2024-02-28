package ru.gb.Tests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Tests.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findUserById(Long id);
    Optional<User> findByEmail(String email);
}
