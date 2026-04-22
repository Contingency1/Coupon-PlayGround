package com.couponplayground.api.user.controller;

import com.couponplayground.api.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserViewController {

    // 임시 더미 데이터 (추후 Service 계층으로 교체)
    private final List<User> dummyUsers = List.of(
            new User(1L, "alice", "alice@example.com"),
            new User(2L, "bob", "bob@example.com"),
            new User(3L, "charlie", "charlie@example.com")
    );

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", dummyUsers);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        User user = dummyUsers.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));

        model.addAttribute("user", user);
        return "user/detail";
    }
}
