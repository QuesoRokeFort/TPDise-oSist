package Hibernate.Model;

import jakarta.persistence.*;
@Entity
@Table (name = "Pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	@Column (name = "nombre")
	private String nombre;

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
}
