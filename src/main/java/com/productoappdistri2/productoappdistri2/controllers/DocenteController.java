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

import com.productoappdistri2.productoappdistri2.entities.Docente;
import com.productoappdistri2.productoappdistri2.services.DocenteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping(path = { "/listar", "/" })
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", docenteService.findAll());
        return "docente/indexDocente";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/docenteForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idDocente) {
        Docente docente = docenteService.findById(idDocente);
        if (docente == null) {
            return "redirect:/docentes/listar";
        }
        model.addAttribute("docente", docente);
        return "docente/docenteForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model,
            @Valid @ModelAttribute("docente") Docente docente,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "docente/docenteForm";
        }
        if (docente.getId() == null) {
            docenteService.save(docente);
        } else {
            docenteService.update(docente);
        }

        return "redirect:/docentes/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDocente(Model model, @PathVariable("id") Long idDocente) {
        docenteService.delete(idDocente);
        return "redirect:/docentes/listar";
    }
}
