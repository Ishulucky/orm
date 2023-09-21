package com.example.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/adduser")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        // Validate the user input and perform necessary actions (e.g., saving to a database)

        if (result.hasErrors()) {
           
            return "user-form";
        }

        // Redirect to a success page or perform other actions
        return "redirect:/success";
    }
}
