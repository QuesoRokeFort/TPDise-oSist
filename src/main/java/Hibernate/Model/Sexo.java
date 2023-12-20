package Hibernate.Model;

public enum Sexo {
	FEMENINO("Femenino"),
	MASCULINO("Masculino"),

	NO_ESPECIFICADO("No Especificado");

	private final String descripcion;

	Sexo(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}