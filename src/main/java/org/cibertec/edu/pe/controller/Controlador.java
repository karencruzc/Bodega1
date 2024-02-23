package org.cibertec.edu.pe.controller;


import java.util.List;
import java.util.Optional;


import org.cibertec.edu.pe.interfaceService.IProductoService;

import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IProductoService servicio;
	
	@GetMapping("/listar")
	public String Listar(Model modelo) {
		List<Producto> productos = servicio.Listado();
		modelo.addAttribute("productos", productos);
		return "index";
	}
	
	
	//Agregar
	@GetMapping("/new")
	public String agregar(Model modelo) {
		modelo.addAttribute("productos", new Producto());
		return "form";
	}
	
	//Guardar
	@PostMapping("/save")
	public String save(@Validated Producto p, Model modelo) {
		servicio.Insertar(p);
		return "redirect:/listar";
	}
	//editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Optional<Producto> p = servicio.Buscar(id);
	
		modelo.addAttribute("productos", p);
		return "form";
	}
	//Model modelo =>Sirve para pasar valores desde el controlador a la vista (Formulario)
//Accion eliminar
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model modelo) {
		servicio.Suprimir(id);
		return "redirect:/listar";
	}
}
