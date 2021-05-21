package ru.gb.artem.marketapril.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.gb.artem.marketapril.dtos.UserDto;
import ru.gb.artem.marketapril.error_handling.ResourceNotFoundException;
import ru.gb.artem.marketapril.models.User;
import ru.gb.artem.marketapril.services.UserService;


import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/me")
    public UserDto getCurrentUsername(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        return new UserDto(currentUser.getUsername(), currentUser.getEmail());
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.createUser(userDto);
    }
}
