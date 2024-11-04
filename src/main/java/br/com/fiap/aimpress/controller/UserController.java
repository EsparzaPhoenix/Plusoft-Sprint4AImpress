package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.model.user.UserAccount;
import br.com.fiap.aimpress.repository.PerfilRepository;
import br.com.fiap.aimpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserAccount());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserAccount userAccount) {
        userService.saveUser(userAccount.getUsername(), userAccount.getPassword(), userAccount.getEmail(), perfilRepository.findAll());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
