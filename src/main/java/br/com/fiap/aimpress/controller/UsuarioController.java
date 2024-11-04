package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.dto.UsuarioDto;
import br.com.fiap.aimpress.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listUsuarios(Model model) {
        List<UsuarioDto> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/list";
    }

    @GetMapping("/{id}")
    public String viewUsuario(@PathVariable Long id, Model model) {
        UsuarioDto usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/view";
    }

    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        model.addAttribute("usuario", new UsuarioDto());
        return "usuarios/form";
    }

    @PostMapping
    public String createUsuario(@ModelAttribute UsuarioDto usuarioDto) {
        usuarioService.createUsuario(usuarioDto);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        UsuarioDto usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    @PostMapping("/editar/{id}")
    public String updateUsuario(@PathVariable Long id, @ModelAttribute UsuarioDto usuarioDto) {
        usuarioService.updateUsuario(id, usuarioDto);
        return "redirect:/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}
