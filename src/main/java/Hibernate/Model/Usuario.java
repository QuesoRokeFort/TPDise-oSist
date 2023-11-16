package Hibernate.Model;

import DTO.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "clave", length = 30)
	private String clave;

	@Column(name = "mail", length = 30)
	private String mail;

	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	private Rol rol;

	@OneToOne(mappedBy = "usuario")
	private Persona persona;

	// Otros atributos y métodos según tus necesidades

	public Usuario() {
	}

	public Usuario(UsuarioDTO usuario) {
		this.id = usuario.getId();
		this.clave = usuario.getClave();
		this.mail = usuario.getMail();
		this.rol = usuario.getRol();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public Usuario(Integer id, String clave, String mail, Rol rol, Persona persona) {
		this.id = id;
		this.clave = clave;
		this.mail = mail;
		this.rol = rol;
		this.persona = persona;
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

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", clave='" + clave + '\'' +
				", mail='" + mail + '\'' +
				", rol=" + rol +
				'}';
	}
}

