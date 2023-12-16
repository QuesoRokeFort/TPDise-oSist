package Hibernate.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "RegistroCambioProvincia")
public class RegistroCambioProvincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer idRegCamProv;
	@Column(name = "fechaCamProv")
	Date fechaCamProv;
	@Column(name="ValorAntiguo")
	Integer valorAntiguo;
	@Column(name = "ValorNuevo")
	Integer valoNuevo;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "idProvincia")
	Provincia provincia;
}
