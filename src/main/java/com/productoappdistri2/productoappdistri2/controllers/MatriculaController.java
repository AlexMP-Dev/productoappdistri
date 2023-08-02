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

import com.productoappdistri2.productoappdistri2.entities.Matricula;
import com.productoappdistri2.productoappdistri2.entities.Nota;
import com.productoappdistri2.productoappdistri2.services.MatriculaService;
import com.productoappdistri2.productoappdistri2.services.NotaService;
import com.productoappdistri2.productoappdistri2.services.PeriodoService;
import com.productoappdistri2.productoappdistri2.services.PagoService;
import com.productoappdistri2.productoappdistri2.services.CursoService;
import com.productoappdistri2.productoappdistri2.services.AlumnoService;

import jakarta.validation.Valid;

@Controller

@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private PeriodoService periodoService;

    @Autowired
    private PagoService pagoService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private NotaService notaService;

    @GetMapping(path = { "/listar", "/" })
    public String listarMatriculas(Model model) {
        model.addAttribute("matriculas", matriculaService.findAll());
        return "matricula/indexMatricula";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("cursos", cursoService.findAll());
        model.addAttribute("alumnos", alumnoService.findAll());
        model.addAttribute("periodos", periodoService.findAll());
        model.addAttribute("pagos", pagoService.findAll());
        return "matricula/matriculaForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idMatricula) {
        Matricula matricula = matriculaService.findById(idMatricula);
        if (matricula == null) {
            return "redirect:/matriculas/listar";
        }
        model.addAttribute("matricula", matricula);
        model.addAttribute("cursos", cursoService.findAll());
        model.addAttribute("alumnos", alumnoService.findAll());
        model.addAttribute("periodos", periodoService.findAll());
        model.addAttribute("pagos", pagoService.findAll());
        return "matricula/matriculaForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model, @Valid @ModelAttribute("matricula") Matricula matricula,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cursos", cursoService.findAll());
            model.addAttribute("alumnos", alumnoService.findAll());
            model.addAttribute("periodos", periodoService.findAll());
            model.addAttribute("pagos", pagoService.findAll());
            return "matricula/matriculaForm";
        }

        if (matricula.getId() == null) {
            Nota nota = new Nota();
            Matricula matricula1 = matriculaService.save(matricula);
            nota.setMatricula(matricula1);
            notaService.save(nota);
        } else {
            matriculaService.update(matricula);
        }

        return "redirect:/matriculas/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMatricula(Model model, @PathVariable("id") Long idMatricula) {
        matriculaService.delete(idMatricula);
        return "redirect:/matriculas/listar";
    }
}
