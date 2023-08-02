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

import com.productoappdistri2.productoappdistri2.entities.Nota;
import com.productoappdistri2.productoappdistri2.services.NotaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/notas")
public class NotaController {

	@Autowired
	private NotaService notaService;

	@GetMapping(path = { "/listar", "/" })
	public String listarNotas(Model model) {
		model.addAttribute("notas", notaService.findAll());
		return "nota/indexNotas";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioNueva(Model model) {
		model.addAttribute("nota", new Nota());
		return "nota/notasForm";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idNota) {
		Nota nota = notaService.findById(idNota);
		if (nota == null) {
			return "redirect:/notas/listar";
		}
		model.addAttribute("nota", nota);
		return "nota/notasForm";
	}

	@PostMapping("/guardar")
	public String procesarFormulario(Model model, @Valid @ModelAttribute("nota") Nota nota,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "nota/notaForm";
		}
		if (nota.getId() == null)
			notaService.save(nota);
		else
			notaService.update(nota);

		return "redirect:/notas/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarNota(Model model, @PathVariable("id") Long idNota) {
		notaService.delete(idNota);
		return "redirect:/notas/listar";
	}
}
