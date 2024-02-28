package ru.gb.Tests.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.Tests.models.User;


@RestController
public interface UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id);

    @PostMapping
    public User createUser(@RequestBody User user);

    @PutMapping("/{id}")
    public User updateBook(@PathVariable Long id, @RequestBody User user);

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id);

    @GetMapping("/request")
    public User getUserByEmail(@PathVariable String email);


}
