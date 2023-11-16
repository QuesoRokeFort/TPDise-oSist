package Hibernate.Model;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMENINO("Femenino"),
	NO_ESPECIFICADO("No Especificado");

	private final String descripcion;

	Sexo(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}