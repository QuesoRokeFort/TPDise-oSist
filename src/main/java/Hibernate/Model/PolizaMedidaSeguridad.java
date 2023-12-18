package Hibernate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Poliza_MedidaSeguridad")
public class PolizaMedidaSeguridad {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private PolizaMedidaSeguridadKey id;

	// Other fields...

	@ManyToOne
	@MapsId("idPoliza")
	@JoinColumn(name = "idPoliza")  // Make sure this matches the actual column name in your database
	private Poliza poliza;

	@ManyToOne
	@MapsId("idMedida")
	@JoinColumn(name = "idMedida")  // Make sure this matches the actual column name in your database
	private MedidaSeguridad medidaSeguridad;

	// Other fields and methods...
}

