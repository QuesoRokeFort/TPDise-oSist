package GestorPersonas;

import DTO.ClienteDTO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
import Hibernate.Dao.PersonaDao;
import Hibernate.Dao.UsuarioDao;
import Hibernate.Model.Cliente;
import Hibernate.Model.Persona;
import Hibernate.Model.Rol;
import Hibernate.Model.Usuario;

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

    public static UsuarioDTO logInUsuario(UsuarioDTO usuario) {
        Usuario usuario1 = UsuarioDao.getUsuarioByMail(usuario.getMail());
        if (usuario1!=null && usuario1.getClave().equals(usuario.getClave())){
            usuario.setRol(usuario1.getRol());
            return usuario;
        }
        return null;
    }
}
