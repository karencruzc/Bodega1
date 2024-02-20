package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.cibertec.edu.pe.modelo.carrito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"lista"})
public class CarritoController {
	
	@ModelAttribute("lista")
	public List<carrito> getLista(){
		return new ArrayList<carrito>();
	}
	@GetMapping("/carrito")
	public String verCarrito() {
		return "carrito";		
	}
	@GetMapping("/comprar/{id}/{cant}") //http://localhost:8085/comprar/1/20
	public String comprar(@PathVariable int id,@PathVariable int cant,Model modelo) {
		List<carrito> miLista = (List<carrito>)modelo.getAttribute("lista");
		//Crear objeto de tipo carrito y asignarle los valores enviados
		carrito ObjC = new carrito(id, cant);
		//Añadirlos a la Lista
		miLista.add(ObjC);
		//Enviarlo a la vista
		modelo.addAttribute("miLista", miLista);
		return "ver";		
	}

}
