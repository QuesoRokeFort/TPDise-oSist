package Hibernate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RegistroCambioCobertura")
public class RegistroCambioCobertura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer idRegCamCob;
	@Column(name = "fechaCamCob")
	Date fechaCamCob;
	@Column(name="ValorAntiguo")
	Integer valorAntiguo;
	@Column(name = "ValorNuevo")
	Integer valoNuevo;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "idLocalidad")
	Cobertura cobertura;
}

