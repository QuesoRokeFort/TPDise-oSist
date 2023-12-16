package Hibernate.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "RegistroCambioLocalidad")
public class RegistroCambioLocalidad {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		Integer idRegCamLoc;
		@Column(name = "fechaCamLoc")
		Date fechaCamProv;
		@Column(name="ValorAntiguo")
		Integer valorAntiguo;
		@Column(name = "ValorNuevo")
		Integer valoNuevo;
		@ManyToOne
		@JoinColumn(name = "idUsuario")
		Usuario usuario;
		@ManyToOne
		@JoinColumn(name = "idLocalidad")
		Localidad localidad;
	}
