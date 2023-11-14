package Hibernate.Model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
	private Integer idPersona;

	@Column(name = "nombrePersona", length = 20)
	private String nombrePersona;

	@Column(name = "apellido", length = 20)
	private String apellido;

	@Column(name = "nroDocumento")
	private Integer nroDocumento;

	@Column(name = "nroCuil")
	private Integer nroCuil;
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", length = 20)
	private Sexo sexo;

	@Column(name = "fechaNac")
	private Date fechaNac;

	@ManyToOne
	@JoinColumn(name = "idDireccion")
	private Direccion direccion;

	@Enumerated(EnumType.STRING)
	@Column(name = "idTipoDocumento")
	private TipoDocumento tipoDocumento;

	@Enumerated(EnumType.STRING)
	@Column(name = "idEstadoCivil")
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.STRING)
	@Column(name = "idProfesion")
	private Profesion profesion;

	@OneToOne
	@JoinColumn(name = "idUsuario", unique = true) // Indica que la relación es única (1 a 1)
	private Usuario usuario;


	public Persona() {
	}

	public Persona(Integer idPersona, String nombrePersona, String apellido, Integer nroDocumento, Integer nroCuil, Sexo sexo, Date fechaNac, Direccion direccion, TipoDocumento tipoDocumento, EstadoCivil estadoCivil, Profesion profesion, Usuario usuario) {
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
		this.usuario = usuario;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Constructor y getters/setters
}