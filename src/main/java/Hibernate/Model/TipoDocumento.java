package Hibernate.Model;


public enum TipoDocumento {
	DNI("Documento Nacional de Identidad"),
	PASAPORTE("Pasaporte"),
	CEDULA("Cédula de Identidad");

	private String descripcion;

	TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
