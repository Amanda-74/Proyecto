package org.proyectosfgk.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.proyectosfgk.entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuariosDAO {
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> listar(){
		return session.getCurrentSession().createQuery("From Usuarios").list();
	}
	
	public void Add(Usuarios u) {
		try {
			session.getCurrentSession().save(u);
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void Update(Usuarios  u) {
		try {
			session.getCurrentSession().update(u);
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void Delete(Usuarios u) {
		try {
			session.getCurrentSession().delete(u);
		}catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public Usuarios obtenerPorId (Integer id) {
		try {
			return (Usuarios) session.getCurrentSession().get(Usuarios.class, id);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
}
