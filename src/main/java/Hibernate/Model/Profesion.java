package Hibernate.Model;

public enum Profesion {
	MEDICO("Médico"),
	INGENIERO("Ingeniero"),
	ABOGADO("Abogado"),
	PROFESOR("Profesor"),
	PROGRAMADOR("Programador"),
	ENFERMERO("Enfermero"),
	ECONOMISTA("Economista"),
	DISEÑADOR("Diseñador"),
	CONTADOR("Contador"),
	POLICIA("Policía");

	private final String descripcion;

	Profesion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
