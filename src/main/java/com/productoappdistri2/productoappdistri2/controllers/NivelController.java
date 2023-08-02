package com.productoappdistri2.productoappdistri2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productoappdistri2.productoappdistri2.entities.Nivel;
import com.productoappdistri2.productoappdistri2.services.NivelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/niveles")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping(path = { "/listar", "/" })
    public String listarNiveles(Model model) {
        model.addAttribute("niveles", nivelService.findAll());
        return "nivel/indexNivel";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("nivel", new Nivel());
        return "nivel/nivelForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idNivel) {
        Nivel nivel = nivelService.findById(idNivel);
        if (nivel == null) {
            return "redirect:/niveles/listar";
        }
        model.addAttribute("nivel", nivel);
        return "nivel/nivelForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model,
            @Valid @ModelAttribute("nivel") Nivel nivel,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "nivel/nivelForm";
        }
        if (nivel.getId() == null) {
            nivelService.save(nivel);
        } else {
            nivelService.update(nivel);
        }

        return "redirect:/niveles/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNivel(Model model, @PathVariable("id") Long idNivel) {
        nivelService.delete(idNivel);
        return "redirect:/niveles/listar";
    }
}
