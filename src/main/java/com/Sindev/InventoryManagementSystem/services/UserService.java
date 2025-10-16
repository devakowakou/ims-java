package com.Sindev.InventoryManagementSystem.services;

import com.Sindev.InventoryManagementSystem.dtos.LoginRequest;
import com.Sindev.InventoryManagementSystem.dtos.RegisterRequest;
import com.Sindev.InventoryManagementSystem.dtos.Response;
import com.Sindev.InventoryManagementSystem.dtos.UserDTO;
import com.Sindev.InventoryManagementSystem.models.User;

public interface UserService {
    Response registerUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    Response getAllUsers();

    User getCurrentLoggedInUser();

    Response getUserById(Long id);

    Response updateUser(Long id, UserDTO userDTO);

    Response deleteUser(Long id);

    Response getUserTransactions(Long id);


}
