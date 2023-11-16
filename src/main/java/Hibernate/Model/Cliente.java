package Hibernate.Model;

import DTO.ClienteDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroCliente")
	private Integer nroCliente;

	@Column(name = "condicionIva", length = 30)
	private String condicionIva;

	@Column(name = "mail", length = 30)
	private String mail;

	@Column(name = "anioRegistro")
	private Integer anioRegistro;

	@Column(name = "estadoCliente" , length = 20)
	private String estadoCliente;

	@Column(name = "nroSiniestros")
	private Integer nroSiniestros;

	@OneToOne
	private Persona persona;

	public Cliente() {
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nroCliente=" + nroCliente +
				", condicionIva='" + condicionIva + '\'' +
				", mail='" + mail + '\'' +
				", anioRegistro=" + anioRegistro +
				", estadoCliente='" + estadoCliente + '\'' +
				", nroSiniestros=" + nroSiniestros +
				'}';
	}

	public Cliente(Integer nroCliente, String condicionIva, String mail, Integer anioRegistro, String estadoCliente, Integer nroSiniestros, Persona persona) {
		this.nroCliente = nroCliente;
		this.condicionIva = condicionIva;
		this.mail = mail;
		this.anioRegistro = anioRegistro;
		this.estadoCliente = estadoCliente;
		this.nroSiniestros = nroSiniestros;
		this.persona = persona;
	}
	public Cliente(ClienteDTO cliente) {
		this.nroCliente = cliente.getNroCliente();
		this.condicionIva = cliente.getCondicionIva();
		this.mail = cliente.getMail();
		this.anioRegistro = cliente.getAnioRegistro();
		this.estadoCliente = cliente.getEstadoCliente();
		this.nroSiniestros = cliente.getNroSiniestros();
	}

	public Integer getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(Integer nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCondicionIva() {
		return condicionIva;
	}

	public void setCondicionIva(String condicionIva) {
		this.condicionIva = condicionIva;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAnioRegistro() {
		return anioRegistro;
	}

	public void setAnioRegistro(Integer anioRegistro) {
		this.anioRegistro = anioRegistro;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public Integer getNroSiniestros() {
		return nroSiniestros;
	}

	public void setNroSiniestros(Integer nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
