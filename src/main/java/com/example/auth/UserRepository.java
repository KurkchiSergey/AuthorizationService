package com.example.auth;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 хранилище в памяти для демонстрации.
 */
@Repository
public class UserRepository {

    // пароль для каждого пользователя
    private final Map<String, String> passwords = Map.of(
            "admin", "admin123",
            "editor", "edit123",
            "guest", "guest123"
    );

    // разрешения для каждого пользователя
    private final Map<String, List<Authorities>> authorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "editor", List.of(Authorities.READ, Authorities.WRITE),
            "guest", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        String stored = passwords.get(user);
        if (stored == null || !stored.equals(password)) {
            return List.of(); // пользователь не найден или пароль неверный — пустой список
        }
        return authorities.getOrDefault(user, List.of());
    }
}
