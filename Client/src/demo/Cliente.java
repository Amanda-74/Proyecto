package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import entidades.Usuarios;

public class Cliente {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		RestTemplate rt = new RestTemplate();
		Usuarios u = new Usuarios();
		
		
		//Crear
		/*Usuarios u = new Usuarios();*/
		
		System.out.println("Ingrese el nombre: ");
		u.setNombre(leer.nextLine());
		System.out.println("Ingrese el apellido: ");
		u.setApellido(leer.nextLine());
		
		rt.postForObject("http://192.168.12.122:8070/MavenSpring/usrs/crear", u, String.class);
		
		//Eliminar
		/*Map<String, Integer> id = new HashMap<String, Integer>();
		id.put("id", 2);
		
		rt.delete("http://192.168.12.122:8070/MavenSpring/usrs/eliminar/{id}", id);*/
		
		//Editar
		/*Usuarios us = new Usuarios();
		
		us.setId(2);
		System.out.println("Ingrese el nombre");
		us.setNombre(leer.nextLine());
		System.out.println("Ingrese el apellido");
		us.setApellido(leer.nextLine());
		
		
		rt.put("http://192.168.12.122:8070/MavenSpring/usrs/editar", us);*/
		
		
		//Usuarios u = rt.getForObject("http://192.168.12.128:8080/MavenSpring/usrs/mostrar/14", Usuarios.class, 200);
		Usuarios[] listado = rt.getForObject("http://192.168.12.122:8070/MavenSpring/usrs/mostrar", Usuarios[].class, 200);
		
		for(Usuarios usu : listado) {
			System.out.println("Id :" + usu.getId());
			System.out.println("Nombre :" + usu.getNombre());
			System.out.println("Apellido :"  + usu.getApellido());
		}
		leer.close();
	}

}
