import Hibernate.Dao.*;
import Hibernate.Model.*;


import java.util.Date;
import java.util.List;

public class App {
	public static void main(String[] args) {
		/*Localidad localidad = new Localidad();
		localidad.setNombre("Santa Fe");
		localidad.setValorDeRiesgo(10);
		localidad.setProvincia(ProvinciaDao.getProvinciaById(1));
		LocalidadDao.saveLocalidad(localidad);*/
		//LocalidadDao.getLocalidades().forEach(l-> System.out.println(l.toString()));
		/*Direccion direccion =new Direccion();
		direccion.setCalle("pedro dias colodrero");
		direccion.setAltura(1645);
		direccion.setPiso("0");
		direccion.setDepto("no");
		direccion.setLocalidad(LocalidadDao.getLocalidadById(1));
		DireccionDao.saveDireccion(direccion);*/
		//DireccionDao.getDirecciones().forEach(d-> System.out.println(d.toString()));
		/*Usuario usuario = new Usuario();
		usuario.setClave("contra");
		usuario.setMail("exg@gmail.com");
		usuario.setRol(Rol.COBRADOR);
		System.out.println(usuario.toString());
		UsuarioDao.saveUsuario(usuario);*/
		//UsuarioDao.getUsuarios().forEach(u -> System.out.println(u.toString()));
		/*Persona persona = new Persona();
		persona.setApellido("Muller");
		persona.setDireccion(DireccionDao.getDireccionById(1));
		persona.setNombrePersona("Lucio");
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setFechaNac(new Date(99, 4, 4));
		persona.setSexo(Sexo.MASCULINO);
		persona.setProfesion(Profesion.PROGRAMADOR);
		persona.setUsuario(UsuarioDao.getUsuarioById(1));
		persona.setNroDocumento(41847630);
		persona.setTipoDocumento(TipoDocumento.DNI);
		PersonaDao.savePersona(persona);*/
		PersonaDao.getAllPersonas().forEach(p->System.out.println(p.toString()));
	}
}
