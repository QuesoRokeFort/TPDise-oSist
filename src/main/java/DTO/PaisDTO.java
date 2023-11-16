package DTO;

import Hibernate.Model.Pais;


public class PaisDTO {
	private int id;
	private String nombre;

	public PaisDTO(PaisDTO pais) {
		this.id = pais.getId();
		this.nombre = pais.getNombre();
	}

	@Override
	public String toString() {
		return "Pais{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}

	public PaisDTO() {
	}

	public PaisDTO(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public PaisDTO(Pais pais){
		this.id = pais.getId();
		this.nombre = pais.getNombre();
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
}
