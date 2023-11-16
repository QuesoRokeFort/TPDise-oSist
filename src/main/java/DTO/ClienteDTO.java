package DTO;

import Hibernate.Model.Cliente;
import Hibernate.Model.Persona;
import jakarta.persistence.*;

public class ClienteDTO {

	private Integer nroCliente;


	private String condicionIva;


	private String mail;


	private Integer anioRegistro;


	private String estadoCliente;


	private Integer nroSiniestros;


	private PersonaDTO persona;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer nroCliente, String condicionIva, String mail, Integer anioRegistro, String estadoCliente, Integer nroSiniestros, PersonaDTO persona) {
		this.nroCliente = nroCliente;
		this.condicionIva = condicionIva;
		this.mail = mail;
		this.anioRegistro = anioRegistro;
		this.estadoCliente = estadoCliente;
		this.nroSiniestros = nroSiniestros;
		this.persona = persona;
	}
	public ClienteDTO(Cliente cliente) {
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

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "ClienteDTO{" +
				"nroCliente=" + nroCliente +
				", condicionIva='" + condicionIva + '\'' +
				", mail='" + mail + '\'' +
				", anioRegistro=" + anioRegistro +
				", estadoCliente='" + estadoCliente + '\'' +
				", nroSiniestros=" + nroSiniestros +
				'}';
	}
}
