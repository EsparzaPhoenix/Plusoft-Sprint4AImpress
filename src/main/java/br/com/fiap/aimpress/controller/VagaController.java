package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.dto.VagaDto;
import br.com.fiap.aimpress.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public String listVagas(Model model) {
        List<VagaDto> vagas = vagaService.getAllVagas();
        model.addAttribute("vagas", vagas);
        return "vagas/list";
    }

    @GetMapping("/{id}")
    public String viewVaga(@PathVariable Long id, Model model) {
        VagaDto vaga = vagaService.getVagaById(id);
        model.addAttribute("vaga", vaga);
        return "vagas/view";
    }

    @GetMapping("/nova")
    public String showCreateForm(Model model) {
        model.addAttribute("vaga", new VagaDto());
        return "vagas/form";
    }

    @PostMapping
    public String createVaga(@ModelAttribute VagaDto vagaDto) {
        vagaService.createVaga(vagaDto);
        return "redirect:/vagas";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        VagaDto vaga = vagaService.getVagaById(id);
        model.addAttribute("vaga", vaga);
        return "vagas/form";
    }

    @PostMapping("/editar/{id}")
    public String updateVaga(@PathVariable Long id, @ModelAttribute VagaDto vagaDto) {
        vagaService.updateVaga(id, vagaDto);
        return "redirect:/vagas";
    }

    @GetMapping("/deletar/{id}")
    public String deleteVaga(@PathVariable Long id) {
        vagaService.deleteVaga(id);
        return "redirect:/vagas";
    }
}
