package it.mystic.chat.model.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PlayerDao(
        Long id,
        @NotNull @Pattern(regexp = "^[A-Za-z]+$", message = "L'username può contenere solamente caratteri alfabetici")
        String username,
        @NotNull @Pattern(regexp = "^[A-Za-z0-9]+$")
        String password,
        @NotNull @Email(message = "Email non valida")
        String email
) {}
