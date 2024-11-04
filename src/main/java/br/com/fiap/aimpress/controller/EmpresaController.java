package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.dto.EmpresaDto;
import br.com.fiap.aimpress.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String listEmpresas(Model model) {
        List<EmpresaDto> empresas = empresaService.getAllEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresas/list";
    }

    @GetMapping("/{id}")
    public String viewEmpresa(@PathVariable Long id, Model model) {
        EmpresaDto empresa = empresaService.getEmpresaById(id);
        model.addAttribute("empresa", empresa);
        return "empresas/view";
    }

    @GetMapping("/nova")
    public String showCreateForm(Model model) {
        model.addAttribute("empresa", new EmpresaDto());
        return "empresas/form";
    }

    @PostMapping
    public String createEmpresa(@ModelAttribute EmpresaDto empresaDto) {
        empresaService.createEmpresa(empresaDto);
        return "redirect:/empresas";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        EmpresaDto empresa = empresaService.getEmpresaById(id);
        model.addAttribute("empresa", empresa);
        return "empresas/form";
    }

    @PostMapping("/editar/{id}")
    public String updateEmpresa(@PathVariable Long id, @ModelAttribute EmpresaDto empresaDto) {
        empresaService.updateEmpresa(id, empresaDto);
        return "redirect:/empresas";
    }

    @GetMapping("/deletar/{id}")
    public String deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
        return "redirect:/empresas";
    }
}
