package ru.gb.Tests.controller.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.Tests.models.User;
import ru.gb.Tests.repository.UserRepository;
import ru.gb.Tests.services.CreateUserService;

import java.util.Map;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "auth/logout";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        /**
         * Проверка на существование логина и email в БД.
         * Если один из них существует, то возвращаем юзера на страницу регистрации
         * с соответствующим сообщением.
         */
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()) {
            model.put("message", "Пользователь или email уже существуют!");
            return "auth/registration";
        }
        createUserService.creatNewUser(user);
        return "redirect:/login";
    }


}