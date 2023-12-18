package Hibernate.Model;


import java.util.Arrays;

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

	public static TipoDocumento[] sortedValues() {
		TipoDocumento[] values = values();
		Arrays.sort(values, (a, b) -> a.getDescripcion().compareToIgnoreCase(b.getDescripcion()));
		return values;
	}
}

