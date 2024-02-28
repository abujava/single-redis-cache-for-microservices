package com.abujava.user;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 8/29/2023
 */
@RestController
@RequestMapping("/api/user/user")
public class UserController {

    private static final List<User> USERS = new ArrayList<>(
            List.of(
                    new User(1L, "user_User#1", "user#1@gmail.com", 18),
                    new User(2L, "user_User#2", "user#2@gmail.com", 14),
                    new User(3L, "user_User#3", "user#3@gmail.com", 12)
            )
    );

    @GetMapping("/{id}")
    @Cacheable(value = "users", key = "#id", cacheManager = "userCacheManager")
    public User getUserById(@PathVariable Long id) {
        return USERS.stream().filter(u -> Objects.equals(u.getId(), id)).findAny().orElseThrow();
    }
}
