package com.medibot.spring.controllers;

import com.medibot.spring.models.Hospitales;
import com.medibot.spring.services.HospitalesService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hospitales")
public class HospitalesController {
       
    	@Autowired
	HospitalesService hospitalesService;
        
        @RequestMapping("/listar")
	public String listar(Model model) {
		List<Hospitales> hospitales = hospitalesService.listar();
		model.addAttribute("hospitales",hospitales);
		model.addAttribute("titulo","Lista de Productos");
		return "hospitalesListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Hospitales hospitales = new Hospitales();
		model.put("hospitales",hospitales);
		model.put("btn", "Crear Producto");
		return "hospitalesForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("hospitales",hospitalesService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "hospitalesForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Valid Hospitales hospitales,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			hospitales = new Hospitales();
			model.addAttribute("hospitales",hospitales);
			model.addAttribute("btn","Crear Producto");
			return "hospitalesForm";
		}else {
		hospitalesService.guardar(hospitales);
		return "redirect:/hospitales/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		hospitalesService.eliminar(id);
		return "redirect:/hospitales/listar";
	}
}
