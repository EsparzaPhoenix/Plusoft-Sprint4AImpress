package br.com.fiap.aimpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPrincipalController {

    @GetMapping("/menu_principal")
    public String showMenuPrincipal() {
        return "menu_principal";
    }

}
