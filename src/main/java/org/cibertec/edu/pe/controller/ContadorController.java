package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"contador","empresa","lista"})
public class ContadorController {
	
	@ModelAttribute("lista")
	public List<String> getLista(){
		List<String> miLista = new ArrayList<>();
		miLista.add("ALGORITMIA");
		miLista.add("BASE DE DATOS");
		miLista.add("DISEÑO DE SISTEMAS");
		miLista.add("DISEÑO WEB");
		miLista.add("APLICACIONES MOVILES");
		return miLista;
		
	}
	
	@ModelAttribute("empresa") // Para asociar + el nombre de la variable
	public String getEmpresa() {
		return "CIBERTEC";
	}
	@ModelAttribute("contador")
	public int getContador() {
		return 1;  //Valor inical en la sesion
		
	}
	@GetMapping("/contador") //http://localhost:8080/contador
	public String verContador() {
		return "contador"; //Como se llama la pagina contador.html
	}
	@GetMapping("/incrementar") //http://localhost:8080/incrementar
	public String incrementar(Model modelo) {
		int contador =(int) modelo.getAttribute("contador");
		String empresa = (String)modelo.getAttribute("empresa");
		List<String> lista =(List<String>)modelo.getAttribute("lista");
		contador++;
		if(contador > 5) {
			empresa="CIBERTEC BREÑA";
			lista.remove(2);
		}
		modelo.addAttribute("contador",contador); //Enviar valor a la vista
		modelo.addAttribute("empresa",empresa);
		modelo.addAttribute("lista",lista);
		return "contador";  //Ir a la p'agina contador.html
	}

}
