package org.proyectosfgk.controllers;

import org.proyectosfgk.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/usuarios")

public class UsuariosController {
	@Autowired
	UsuariosServicio servicio;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("listado", servicio.listar());
		mav.setViewName("usuarios");
		return mav;
	}
}