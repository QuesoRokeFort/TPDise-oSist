package Hibernate.Model;


public enum TipoDocumento {
	DNI("Documento Nacional de Identidad"),
	CUIT("Cuit");

	private String descripcion;

	TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
