package DTO;

import Hibernate.Model.Direccion;



public class DireccionDTO {

	private Integer id;


	private String calle;


	private String piso;


	private Integer altura;


	private String depto;


	private LocalidadDTO localidad;
	public DireccionDTO(Direccion direccion) {
		this.id = direccion.getId();
		this.calle = direccion.getCalle();
		this.piso = direccion.getPiso();
		this.altura = direccion.getAltura();
		this.depto = direccion.getDepto();
		this.localidad = new LocalidadDTO(direccion.getLocalidad());
	}

	public DireccionDTO() {
	}

	public DireccionDTO(Integer id, String calle, String piso, Integer altura, String depto, LocalidadDTO localidad) {
		this.id = id;
		this.calle = calle;
		this.piso = piso;
		this.altura = altura;
		this.depto = depto;
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "DireccionDTO{" +
				"id=" + id +
				", calle='" + calle + '\'' +
				", piso='" + piso + '\'' +
				", altura=" + altura +
				", depto='" + depto + '\'' +
				", localidad=" + localidad +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}
}
