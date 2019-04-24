package org.proyectosfgk.controllers;

import java.util.List;

import org.proyectosfgk.entidades.Usuarios;
import org.proyectosfgk.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/usrs")
public class UsuariosControlador {
	@Autowired
	private UsuariosServicio uServicio;
	
	@RequestMapping(path = "/mostrar")
	public List<Usuarios> mostrar () {
		return uServicio.listar();
	}
	
	@RequestMapping(path = "/mostrar/{id}")
	public Usuarios mostrar (@PathVariable("id") Integer id) {
		return uServicio.obtenerPorId(id);
	}
	
	@RequestMapping(path = "/crear", method = RequestMethod.POST)
	public Usuarios crear (@RequestBody Usuarios u) {
		uServicio.add(u);
		return u;
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public Usuarios editar (@RequestBody Usuarios u) {
		uServicio.update(u);
		return u;
	}
	
	@RequestMapping (path = "/eliminar")
	public Usuarios eliminar (@RequestBody Usuarios u) {
		uServicio.delete(u);
		return u;
	}
	
	@RequestMapping (path = "/eliminar/{id}", method = RequestMethod.GET)
	public Integer eliminar (@PathVariable("id") Integer id){
		uServicio.delete(id);
		return id;
	}
}