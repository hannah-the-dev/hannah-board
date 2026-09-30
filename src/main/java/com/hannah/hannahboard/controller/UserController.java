package com.hannah.hannahboard.controller;

import com.hannah.hannahboard.exception.PostNotFoundException;
import com.hannah.hannahboard.service.UserService;
import dto.UserRequest;
import dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserRequest request) throws Exception {
        UserResponse user = userService.signUp(request);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("user/{id}")
    public String getUser(@PathVariable Long id, Model model) throws PostNotFoundException {
        UserResponse user = userService.getUser(id);
        model.addAttribute("user", user);
        return "myinfo";
    }

    @GetMapping("/check-username")
    public boolean checkUsername(@RequestParam String username) {
        return userService.isUsernamePresent(username);

    }
}
