package DTO;

import Hibernate.Model.Persona;
import Hibernate.Model.Rol;
import Hibernate.Model.Usuario;
import jakarta.persistence.*;

public class UsuarioDTO {

	private Integer id;
	private String clave;
	private String mail;
	private Rol rol;
	private PersonaDTO persona;

	@Override
	public String toString() {
		return "UsuarioDTO{" +
				"id=" + id +
				", clave='" + clave + '\'' +
				", mail='" + mail + '\'' +
				", rol=" + rol +
				'}';
	}

	public UsuarioDTO() {
	}

	public UsuarioDTO(Integer id, String clave, String mail, Rol rol, PersonaDTO persona) {
		this.id = id;
		this.clave = clave;
		this.mail = mail;
		this.rol = rol;
		this.persona = persona;
	}
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.clave = usuario.getClave();
		this.mail = usuario.getMail();
		this.rol = usuario.getRol();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
}
