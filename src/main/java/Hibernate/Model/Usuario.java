package Hibernate.Model;

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

	@Column(name = "mail", length = 20)
	private String mail;

	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	private Rol rol;

	@OneToOne(mappedBy = "usuario")
	private Persona persona;

	// Otros atributos y métodos según tus necesidades

	public Usuario() {
	}

	public Usuario(String clave, String mail, Rol rol) {
		this.clave = clave;
		this.mail = mail;
		this.rol = rol;
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

