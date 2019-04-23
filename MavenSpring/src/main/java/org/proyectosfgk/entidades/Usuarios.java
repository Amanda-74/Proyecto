package org.proyectosfgk.entidades;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "Id")
	private int id;

	@Column(name = "Nombre")
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
