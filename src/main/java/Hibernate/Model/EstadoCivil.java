package Hibernate.Model;

public enum EstadoCivil {
	SOLTERO("Soltero/a"),
	CASADO("Casado/a"),
	DIVORCIADO("Divorciado/a"),
	VIUDO("Viudo/a");

	private final String descripcion;

	EstadoCivil(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
