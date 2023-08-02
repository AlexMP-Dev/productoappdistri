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

import com.productoappdistri2.productoappdistri2.entities.Curso;

import com.productoappdistri2.productoappdistri2.services.CursoService;
import com.productoappdistri2.productoappdistri2.services.NivelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private NivelService nivelService;

    @GetMapping(path = { "/listar", "/" })
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "curso/indexCurso";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("niveles", nivelService.findAll());
        return "curso/cursoForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idCurso) {
        Curso curso = cursoService.findById(idCurso);
        if (curso == null) {
            return "redirect:/cursos/listar";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("niveles", nivelService.findAll());
        return "curso/cursoForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model,
            @Valid @ModelAttribute("curso") Curso curso,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "curso/cursoForm";
        }
        if (curso.getId() == null) {
            cursoService.save(curso);
        } else {
            cursoService.update(curso);
        }

        return "redirect:/cursos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(Model model, @PathVariable("id") Long idCurso) {
        cursoService.delete(idCurso);
        return "redirect:/cursos/listar";
    }
}
