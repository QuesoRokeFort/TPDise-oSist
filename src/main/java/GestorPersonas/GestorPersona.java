package GestorPersonas;

import DTO.PersonaDTO;
import Hibernate.Dao.PersonaDao;
import Hibernate.Model.Persona;
import Hibernate.Model.Rol;

public class GestorPersona {

    public static void crearCliente(PersonaDTO personaDTO) {
        Persona persona = new Persona(personaDTO);
        persona.getUsuario().setRol(Rol.CLIENTE);
        persona.getUsuario().setClave("");
        persona.getUsuario().setMail(personaDTO.getUsuario().getMail());
        System.out.println(persona.toString());
        PersonaDao.savePersona(persona);
    }
}
