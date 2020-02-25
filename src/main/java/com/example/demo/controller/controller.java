package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.interfacesService.IPersonaService;
import com.example.demo.model.Persona;

@Controller
@RequestMapping
public class controller {
	@Autowired
	private IPersonaService service;

	@GetMapping("/listar")
	public String listar(Model modelo) {
		List<Persona> personas = service.listar();
		modelo.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Valid Persona p, Model modelo) {
		service.save(p);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Optional<Persona> persona = service.listarID(id);
		modelo.addAttribute("persona", persona);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model modelo, @PathVariable int id) {
		service.delete(id);
         return  "redirect:/listar";
	}
}
