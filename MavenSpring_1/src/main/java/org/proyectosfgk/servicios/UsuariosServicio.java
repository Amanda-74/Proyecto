package org.proyectosfgk.servicios;

import java.util.List;

import org.proyectosfgk.dao.UsuariosDAO;
import org.proyectosfgk.entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicio {
	@Autowired
	UsuariosDAO dao;
	
	public List<Usuarios> listar(){
		return dao.listar();
	}
	
	public void add(Usuarios u) {
		dao.Add(u);
	}
	
	public void update(Usuarios u) {
		dao.Update(u);
	}
	
	public void delete(Usuarios u) {
		dao.Delete(u);
	}
	
	public Usuarios obtenerPorId (Integer id) {
		return dao.obtenerPorId(id);
	}
	
	public void delete (Integer id) {
		dao.Delete(dao.obtenerPorId(id));
	}
}