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

import com.productoappdistri2.productoappdistri2.entities.Periodo;
import com.productoappdistri2.productoappdistri2.services.PeriodoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoService periodoService;

    @GetMapping(path = { "/listar", "/" })
    public String listarPeriodos(Model model) {
        model.addAttribute("periodos", periodoService.findAll());
        return "periodo/indexPeriodo";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("periodo", new Periodo());
        return "periodo/periodoForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idPeriodo) {
        Periodo periodo = periodoService.findById(idPeriodo);
        if (periodo == null) {
            return "redirect:/periodos/listar";
        }
        model.addAttribute("periodo", periodo);
        return "periodo/periodoForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model, 
        @Valid @ModelAttribute("periodo") Periodo periodo,
        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "periodo/periodoForm";
        }
        
        if (periodo.getId() == null){
            periodoService.save(periodo);
        }else{
            periodoService.update(periodo);
        }
        return "redirect:/periodos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPeriodo(Model model, @PathVariable("id") Long idPeriodo) {
        periodoService.delete(idPeriodo);
        return "redirect:/periodos/listar";
    }
}
