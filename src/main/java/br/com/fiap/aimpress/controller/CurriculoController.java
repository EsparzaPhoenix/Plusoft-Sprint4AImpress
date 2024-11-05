package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.dto.CurriculoDto;
import br.com.fiap.aimpress.repository.CurriculoRepository;
import br.com.fiap.aimpress.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public String listCurriculos(Model model) {
        List<CurriculoDto> curriculos = curriculoService.getAllCurriculos();
        model.addAttribute("curriculos", curriculos);
        return "curriculos/curriculo_list";
    }

    @GetMapping("/{id}")
    public String viewCurriculo(@PathVariable Long id, Model model) {
        try {
            CurriculoDto curriculo = curriculoService.getCurriculoById(id);
            model.addAttribute("curriculo", curriculo);
            return "curriculos/view"; // Certifique-se de que este HTML existe e está corretamente configurado
        } catch (RuntimeException e) {
            // Mensagem de erro caso o currículo não seja encontrado
            model.addAttribute("errorMessage", "Currículo não encontrado.");
            return "curriculos/curriculo_list"; // Retorna para a lista de currículos com a mensagem de erro
        }
    }


    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        model.addAttribute("curriculo", new CurriculoDto());
        return "curriculos/curriculo_form";
    }

    @PostMapping
    public String createCurriculo(@ModelAttribute CurriculoDto curriculoDto) {
        curriculoService.createCurriculo(curriculoDto);
        return "redirect:/curriculos";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        CurriculoDto curriculo = curriculoService.getCurriculoById(id);
        model.addAttribute("curriculo", curriculo);
        return "curriculos/form";
    }

    @PostMapping("/editar/{id}")
    public String updateCurriculo(@PathVariable Long id, @ModelAttribute CurriculoDto curriculoDto) {
        curriculoService.updateCurriculo(id, curriculoDto);
        return "redirect:/curriculos";
    }

    @GetMapping("/deletar/{id}")
    public String deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
        return "redirect:/curriculos";
    }
}
