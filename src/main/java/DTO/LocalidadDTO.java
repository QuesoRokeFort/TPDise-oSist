package DTO;


import Hibernate.Model.Localidad;
import Hibernate.Model.Provincia;


public class LocalidadDTO {
	private int id;

	private String nombre;

	private int valorDeRiesgo;

	private ProvinciaDTO provincia;

	@Override
	public String toString() {
		return "LocalidadDTO{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", valorDeRiesgo=" + valorDeRiesgo +
				", provincia=" + provincia +
				'}';
	}

	public LocalidadDTO(LocalidadDTO localidad) {
		this.id = localidad.getId();
		this.nombre = localidad.getNombre();
		this.valorDeRiesgo = localidad.getValorDeRiesgo();
		this.provincia = new ProvinciaDTO(localidad.getProvincia());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValorDeRiesgo() {
		return valorDeRiesgo;
	}

	public void setValorDeRiesgo(int valorDeRiesgo) {
		this.valorDeRiesgo = valorDeRiesgo;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = new ProvinciaDTO(provincia);
	}

	public LocalidadDTO(Localidad localidad) {
		this.id = localidad.getId();
		this.nombre = localidad.getNombre();
		this.valorDeRiesgo = localidad.getValorDeRiesgo();
		this.provincia = new ProvinciaDTO(localidad.getProvincia());
	}

	public LocalidadDTO(int id, String nombre, int valorDeRiesgo, Provincia provincia) {
		this.id = id;
		this.nombre = nombre;
		this.valorDeRiesgo = valorDeRiesgo;
		this.provincia = new ProvinciaDTO(provincia);
	}

	public LocalidadDTO() {
	}
}
