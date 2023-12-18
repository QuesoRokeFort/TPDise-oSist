package Hibernate.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PolizaMedidaSeguridadKey implements Serializable {
	@Column(name = "idMedida")
	private Integer idMedida;

	@Column(name = "idPoliza")
	private Integer idPoliza;

}

