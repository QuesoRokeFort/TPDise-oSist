package DTO;

import Hibernate.Model.Localidad;
import Hibernate.Model.Pais;
import Hibernate.Model.Provincia;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ProvinciaDTO {

	private int id;

	private String nombre;


	private int codPostal;

	private PaisDTO pais;

	public ProvinciaDTO(int id, String nombre, int codPostal, Pais pais) {
		this.id = id;
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.pais = new PaisDTO(pais);
	}
	public ProvinciaDTO(Provincia provincia) {
		this.id = provincia.getId();
		this.nombre = provincia.getNombre();
		this.codPostal = provincia.getCodPostal();
		this.pais = new PaisDTO(provincia.getPais());
	}

	public ProvinciaDTO() {
	}

	public ProvinciaDTO(ProvinciaDTO provincia) {
		this.id = provincia.getId();
		this.nombre = provincia.getNombre();
		this.codPostal = provincia.getCodPostal();
		this.pais = new PaisDTO(provincia.getPais());
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

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais =new PaisDTO(pais);
	}

	@Override
	public String toString() {
		return "ProvinciaDTO{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", codPostal=" + codPostal +
				", pais=" + pais +
				'}';
	}
}
