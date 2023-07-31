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

import com.productoappdistri2.productoappdistri2.entities.Alumno;
import com.productoappdistri2.productoappdistri2.services.AlumnoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping(path = { "/listar", "/" })
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", service.findAll());
        return "alumno/indexAlumno";
    }

    @GetMapping("/nuevo")
    public String MostrarFormularioNuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumno/alumnoForm";
    }

    @GetMapping("/editar/{id}")
    public String MostrarFormularioEditar(Model model,
            @PathVariable("id") Long idAlumno) {

        Alumno aux = service.findById(idAlumno);
        model.addAttribute("alumno", aux != null ? aux : new Alumno());

        return "alumno/alumnoForm";
    }

    @PostMapping("/guardar")
    public String ProcesarFormulario(Model model,
            @Valid @ModelAttribute("alumno") Alumno alumno,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "alumno/alumnoForm";

        if (alumno.getId() == null)
            service.save(alumno);
        else
            service.update(alumno);

        return "redirect:/alumnos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String alumnoEliminar(Model model,
            @PathVariable("id") Long idAlumno) {

        service.delete(idAlumno);
        return "redirect:/alumnos/listar";
    }
}
