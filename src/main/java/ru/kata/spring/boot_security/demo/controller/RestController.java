package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/person")
    public User getPerson(@AuthenticationPrincipal User user) {
        return userService.getUserByName(user.getName());
    }

    @GetMapping("/new")
    public User getNewUser() {
        return new User();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/allroles")
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @PatchMapping("/edit")
    public String editUser(@RequestBody User user) {
        userService.updateUser(user);
        return "update ok";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.removeUser(id);
        return "delete ok";
    }

    @PostMapping("/save")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "add user ok";
    }
}