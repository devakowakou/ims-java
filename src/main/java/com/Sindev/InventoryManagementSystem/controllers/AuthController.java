package com.Sindev.InventoryManagementSystem.controllers;

import com.Sindev.InventoryManagementSystem.dtos.LoginRequest;
import com.Sindev.InventoryManagementSystem.dtos.RegisterRequest;
import com.Sindev.InventoryManagementSystem.dtos.Response;
import com.Sindev.InventoryManagementSystem.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }


}

