package com.productoappdistri2.productoappdistri2.controllers;
/* 
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
import com.productoappdistri2.productoappdistri2.entities.Usuario;
import com.productoappdistri2.productoappdistri2.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = { "/listar", "/" })
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuario/indexUsuario";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuarioForm";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(Model model, @PathVariable("id") Long idUsuario) {
        Usuario usuario = usuarioService.buscar(idUsuario);
        if (usuario == null) {
            return "redirect:/usuarios/listar";
        }
        model.addAttribute("usuario", usuario);
        return "usuario/usuarioForm";
    }

    @PostMapping("/guardar")
    public String procesarFormulario(Model model, @Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult bindingResult) {
       
    	if (bindingResult.hasErrors()) {
            return "usuario/usuarioForm";
        }
    	
    	if (usuario.getId() == null)
           usuarioService.save(usuario); 
        else
    	usuarioService.update(usuario); 
       
        return "redirect:/usuarios/listar";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(Model model, @PathVariable("id") Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect:/usuarios/listar";
    }
}
*/
