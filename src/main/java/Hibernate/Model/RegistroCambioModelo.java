package Hibernate.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "RegistroCambioModelo")
public class RegistroCambioModelo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		Integer idRegCamMod;
		@Column(name = "fechaCamMod")
		Date fechaCamProv;
		@Column(name="ValorAntiguo")
		Integer valorAntiguo;
		@Column(name = "ValorNuevo")
		Integer valoNuevo;
		@ManyToOne
		@JoinColumn(name = "idUsuario")
		Usuario usuario;
		@ManyToOne
		@JoinColumn(name = "idModelo")
		Modelo modelo;
	}


