package Hibernate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RegistroCambioMedSeg")
public class RegistroCambioMedSeg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer idRegCamMed;
	@Column(name = "fechaCamCob")
	Date fechaCamMed;
	@Column(name="ValorAntiguo")
	Integer valorAntiguo;
	@Column(name = "ValorNuevo")
	Integer valoNuevo;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "idLocalidad")
	MedidaSeguridad medidaSeguridad;
}
