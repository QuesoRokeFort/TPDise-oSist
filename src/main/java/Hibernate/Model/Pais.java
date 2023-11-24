package Hibernate.Model;

import DTO.PaisDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	@Column (name = "nombre", length = 20)
	private String nombre;

	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Provincia> provincias = new ArrayList<>();

	public Pais(PaisDTO paisDTO) {
		this.id = paisDTO.getId();
		this.nombre = paisDTO.getNombre();
	}

	@Override
	public String toString() {
		return "Pais{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}

	public Pais() {
	}

	public Pais(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public List<Provincia> getProvincias() {
		return provincias;
	}
}