package Hibernate.Model;

public enum EstadoCivil {
	CASADO("Casado/a"),
	DIVORCIADO("Divorciado/a"),
	SOLTERO("Soltero/a"),


	VIUDO("Viudo/a");

	private final String descripcion;

	EstadoCivil(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
