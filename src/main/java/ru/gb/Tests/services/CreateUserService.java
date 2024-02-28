package ru.gb.Tests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gb.Tests.models.User;
import ru.gb.Tests.repository.UserRepository;

@Service
public class CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        userRepository.save(user);
    }
    public void creatNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        save(user);
    }

    public User getUserById(Long id){
        return userRepository.findUserById(id);
    }
}
