package Hibernate.Model;


import DTO.DireccionDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Direccion")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "calle", length = 20)
	private String calle;

	@Column(name = "piso", length = 20)
	private String piso;

	@Column(name = "altura")
	private Integer altura;

	@Column(name = "depto", length = 20)
	private String depto;

	@ManyToOne
	@JoinColumn(name = "idLocalidad")
	private Localidad localidad;
	@ManyToOne
	@JoinColumn(name = "idPersona",nullable = false)
	private Persona persona;

	public Direccion() {
	}

	public Direccion(Integer idDireccion, String calle, String piso, Integer altura, String depto, Localidad localidad) {
		this.id = idDireccion;
		this.calle = calle;
		this.piso = piso;
		this.altura = altura;
		this.depto = depto;
		this.localidad = localidad;
	}



    public Direccion(DireccionDTO direccion) {
		this.id = direccion.getId();
		this.calle = direccion.getCalle();
		this.piso = direccion.getPiso();
		this.altura = direccion.getAltura();
		this.depto = direccion.getDepto();
		this.localidad = new Localidad(direccion.getLocalidad());

	}

    public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Direccion{" +
				"id=" + id +
				", calle='" + calle + '\'' +
				", piso='" + piso + '\'' +
				", altura=" + altura +
				", depto='" + depto + '\'' +
				", localidad=" + localidad +
				'}';
	}

	public Persona getPersona() {
		return persona;
	}
}
