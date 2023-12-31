package Hibernate.Model;


public enum Rol {
	COBRADOR("Cobrador"),
	GERENTE("Gerente"),
	PRODUCTOR_SEGURO("Productor de Seguros"),
	CLIENTE("Cliente");
	private final String descripcion;

	Rol(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
