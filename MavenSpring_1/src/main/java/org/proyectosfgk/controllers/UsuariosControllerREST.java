package org.proyectosfgk.controllers;

import java.util.List;

import org.proyectosfgk.entidades.Usuarios;
import org.proyectosfgk.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosControllerREST {
	@Autowired
	UsuariosServicio uServicio;
	
	@RequestMapping(path = "/mostrar", produces = "application/json")
	public List<Usuarios> mostrar () {
		return uServicio.listar();
	}
	
	@RequestMapping(path = "/mostrar/{id}", produces = "application/json")
	public Usuarios mostrar (@PathVariable("id") Integer id) {
		return uServicio.obtenerPorId(id);
	}
}