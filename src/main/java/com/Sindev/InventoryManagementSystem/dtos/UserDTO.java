package com.Sindev.InventoryManagementSystem.dtos;

import com.Sindev.InventoryManagementSystem.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    private UserRole role;

    private List<TransactionDTO> transactions;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
