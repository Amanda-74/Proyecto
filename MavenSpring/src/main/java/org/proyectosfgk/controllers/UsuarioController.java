package org.proyectosfgk.controllers;

import java.util.List;
import org.proyectosfgk.entidades.Usuarios;
import org.proyectosfgk.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/usr")
public class UsuarioController {
	@Autowired
	UsuariosServicio uServicio;
	
	@RequestMapping (path = "/mostrar")
	public List<Usuarios> mostrar(){
		return uServicio.listar();
		
	}
	
	@RequestMapping (path = "/mostrar/{id}")
	public Usuarios mostrar(@PathVariable("id") Integer id) {
		return uServicio.obtenerPorId(id);
	}
	
	@RequestMapping(path = "/crear", method = RequestMethod.POST)//Colocar RequestBody al objeto completo
	public Usuarios crear(@RequestBody Usuarios u) {
		uServicio.Add(u);
		return u;
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public Usuarios modificar(@RequestBody Usuarios u) {
		uServicio.Udpdate(u);
		return u;
	}
	
	
	@RequestMapping(path = "/eliminar", method = RequestMethod.DELETE)
	public Usuarios eliminar(@RequestBody Usuarios u) {
		uServicio.Delete(u);
		return u;
	}
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.GET)
	public Integer eliminar (@PathVariable("id") Integer id) {
		Usuarios u = uServicio.obtenerPorId(id);
		uServicio.Delete(u);
		return id;
		
	}
	
}
