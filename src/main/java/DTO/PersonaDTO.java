package DTO;



import Hibernate.Model.*;

import java.util.Date;

public class PersonaDTO {

	private Integer idPersona;


	private String nombrePersona;

	private String apellido;


	private Integer nroDocumento;


	private Integer nroCuil;

	private Sexo sexo;


	private Date fechaNac;


	private DireccionDTO direccion;


	private TipoDocumento tipoDocumento;


	private EstadoCivil estadoCivil;


	private Profesion profesion;


	private UsuarioDTO usuario;

	private ClienteDTO cliente;

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public PersonaDTO() {
	}

	public PersonaDTO(Integer idPersona, String nombrePersona, String apellido, Integer nroDocumento, Integer nroCuil, Sexo sexo, Date fechaNac, DireccionDTO direccion, TipoDocumento tipoDocumento, EstadoCivil estadoCivil, Profesion profesion, Usuario usuario) {
		this.idPersona = idPersona;
		this.nombrePersona = nombrePersona;
		this.apellido = apellido;
		this.nroDocumento = nroDocumento;
		this.nroCuil = nroCuil;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.tipoDocumento = tipoDocumento;
		this.estadoCivil = estadoCivil;
		this.profesion = profesion;
		this.usuario = new UsuarioDTO(usuario);
	}
	public PersonaDTO(Persona persona) {
		this.idPersona = persona.getIdPersona();
		this.nombrePersona = persona.getNombrePersona();
		this.apellido = persona.getApellido();
		this.nroDocumento = persona.getNroDocumento();
		this.nroCuil = persona.getNroCuil();
		this.sexo = persona.getSexo();
		this.fechaNac = persona.getFechaNac();
		this.direccion = new DireccionDTO(persona.getDireccion());
		this.tipoDocumento = persona.getTipoDocumento();
		this.estadoCivil = persona.getEstadoCivil();
		this.profesion = persona.getProfesion();
		this.usuario = new UsuarioDTO(persona.getUsuario());
		usuario.setPersona(this);
		this.cliente = new ClienteDTO(persona.getCliente());
		cliente.setPersona(this);
	}

	@Override
	public String toString() {
		return "Persona{" +
				"idPersona=" + idPersona +
				", nombrePersona='" + nombrePersona + '\'' +
				", apellido='" + apellido + '\'' +
				", nroDocumento=" + nroDocumento +
				", nroCuil=" + nroCuil +
				", sexo='" + sexo + '\'' +
				", fechaNac=" + fechaNac +
				", direccion=" + direccion +
				", tipoDocumento=" + tipoDocumento +
				", estadoCivil=" + estadoCivil +
				", profesion=" + profesion +
				", usuario=" + usuario +
				", cliente=" + cliente +
				'}';
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Integer getNroCuil() {
		return nroCuil;
	}

	public void setNroCuil(Integer nroCuil) {
		this.nroCuil = nroCuil;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}
}
