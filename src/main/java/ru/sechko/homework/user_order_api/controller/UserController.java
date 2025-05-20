package ru.sechko.homework.user_order_api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.sechko.homework.user_order_api.model.User;
import ru.sechko.homework.user_order_api.service.UserService;
import ru.sechko.homework.user_order_api.view.Views;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @JsonView(Views.UserDetails.class)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.UserSummary.class)
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @JsonView(Views.UserSummary.class)
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    @JsonView(Views.UserSummary.class)
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
