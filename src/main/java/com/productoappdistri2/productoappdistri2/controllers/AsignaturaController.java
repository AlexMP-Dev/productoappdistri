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

import com.productoappdistri2.productoappdistri2.entities.Asignatura;
import com.productoappdistri2.productoappdistri2.services.AsignaturaService;
import com.productoappdistri2.productoappdistri2.services.DocenteService;
import com.productoappdistri2.productoappdistri2.services.CursoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private CursoService cursoService;

    @GetMapping(path = { "/listar", "/" })
    public String listarAsignaturas(Model model) {
        model.addAttribute("asignaturas", asignaturaService.findAll());
        return "asignatura/indexAsignatura";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("cursos", cursoService.findAll());
        
        return "asignatura/asignaturaForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idAsignatura) {
        Asignatura asignatura = asignaturaService.findById(idAsignatura);
        if (asignatura == null) {
            return "redirect:/asignaturas/listar";
        }
        model.addAttribute("asignatura", asignatura);
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("cursos", cursoService.findAll());
        return "asignatura/asignaturaForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model, @Valid @ModelAttribute("asignatura") Asignatura asignatura,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("docentes", docenteService.findAll());
            model.addAttribute("cursos", cursoService.findAll());
            return "asignatura/asignaturaForm";
        }

        asignaturaService.save(asignatura);
        return "redirect:/asignaturas/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(Model model, @PathVariable("id") Long idAsignatura) {
        asignaturaService.delete(idAsignatura);
        return "redirect:/asignaturas/listar";
    }
}
