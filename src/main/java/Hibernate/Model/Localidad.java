package Hibernate.Model;

import DTO.LocalidadDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Localidad {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "nombre", length = 20)
	private String nombre;
	@Column (name = "valorDeRiesgo")
	private int valorDeRiesgo;
	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	public Localidad() {
	}

	public Localidad(int id, String nombre, int valorDeRiesgo, Provincia provincia) {
		this.id = id;
		this.nombre = nombre;
		this.valorDeRiesgo = valorDeRiesgo;
		this.provincia = provincia;
	}

    public Localidad(LocalidadDTO localidad) {
		this.id = localidad.getId();
		this.nombre = localidad.getNombre();
		this.valorDeRiesgo = localidad.getValorDeRiesgo();
		this.provincia = new Provincia(localidad.getProvincia());
	}

    @Override
	public String toString() {
		return "Localidad{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", valorDeRiesgo=" + valorDeRiesgo +
				", provincia=" + provincia +
				'}';
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
