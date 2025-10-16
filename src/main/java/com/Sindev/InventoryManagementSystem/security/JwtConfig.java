package com.Sindev.InventoryManagementSystem.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.jwt")
@Data
public class JwtConfig {
    private String secret = "Sindhu1431Sindhu2901SecureJWTKey1234";
    private long expirationMs = 1000L * 60L * 60L * 24L * 30L * 6L; // 6 months
}
