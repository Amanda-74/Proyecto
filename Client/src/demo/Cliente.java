package demo;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import entidades.Usuarios;

public class Cliente {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		RestTemplate rt = new RestTemplate();
		
		Usuarios u = new Usuarios();
		
		System.out.println("Ingrese el nombre: ");
		u.setNombre(leer.nextLine());
		System.out.println("Ingrese el apellido");
		u.setApellido(leer.nextLine());
		
		rt.postForObject("http://192.168.12.122:8070/MavenSpring/usrs/crear", u, String.class);
		
		//Usuarios u = rt.getForObject("http://192.168.12.128:8080/MavenSpring/usrs/mostrar/14", Usuarios.class, 200);
		Usuarios[] listado = rt.getForObject("http://192.168.12.122:8070/MavenSpring/usrs/mostrar", Usuarios[].class, 200);
		
		for(Usuarios us : listado) {
			System.out.println("Id :" + us.getId());
			System.out.println("Nombre :" + us.getNombre());
			System.out.println("Apellido :"  + us.getApellido());
		}
		leer.close();
	}

}
