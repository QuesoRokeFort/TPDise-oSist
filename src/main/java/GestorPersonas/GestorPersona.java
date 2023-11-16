package GestorPersonas;

import DTO.ClienteDTO;
import DTO.PersonaDTO;
import Hibernate.Dao.PersonaDao;
import Hibernate.Model.Cliente;
import Hibernate.Model.Persona;
import Hibernate.Model.Rol;

public class GestorPersona {

    public static void crearCliente(PersonaDTO personaDTO) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setAnioRegistro(2023);
        cliente.setPersona(personaDTO);
        cliente.setMail(personaDTO.getUsuario().getMail());
        cliente.setEstadoCliente("activo");
        cliente.setCondicionIva("buena"); // a mirar nose como funcionan las condiciones de iva
        cliente.setNroSiniestros(0);
        personaDTO.setCliente(cliente);
        Persona persona = new Persona(personaDTO);
        persona.setUsuario(null);
        PersonaDao.savePersona(persona);
    }
}
