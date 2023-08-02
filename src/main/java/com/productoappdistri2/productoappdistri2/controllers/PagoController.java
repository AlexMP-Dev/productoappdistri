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

import com.productoappdistri2.productoappdistri2.entities.Pago;
import com.productoappdistri2.productoappdistri2.services.AlumnoService;
import com.productoappdistri2.productoappdistri2.services.PagoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping(path = { "/listar", "/" })
    public String listarPagos(Model model) {
        model.addAttribute("pagos", pagoService.findAll());
        return "pago/indexPago";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("alumnos", alumnoService.findAll()); // Lista de alumnos para el dropdown
        return "pago/pagoForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, 
        @PathVariable("id") Long idPago) {
        Pago pago = pagoService.findById(idPago);
        
        model.addAttribute("pago", pago);
        model.addAttribute("alumnos", alumnoService.findAll()); // Lista de alumnos para el dropdown
        return "pago/pagoForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model, 
    @Valid @ModelAttribute("pago") Pago pago,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("alumnos", alumnoService.findAll()); // Lista de alumnos para el dropdown
            return "pago/pagoForm";
        }

        if(pago.getId() == null) {
            pagoService.save(pago);
        } else {
            pagoService.update(pago);

        }
        return "redirect:/pagos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPago(Model model, 
    @PathVariable("id") Long idPago) {
        pagoService.delete(idPago);
        return "redirect:/pagos/listar";
    }
}
