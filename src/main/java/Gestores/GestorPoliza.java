package Gestores;

import DTO.CoberturaDTO;
import DTO.LocalidadDTO;
import DTO.PolizaDTO;
import DTO.VehiculoDTO;
import Hibernate.Dao.PolizaDao;
import Hibernate.Model.Poliza;

public class GestorPoliza {
	public static void crearPoliza(PolizaDTO currentPoliza, LocalidadDTO l, VehiculoDTO v, CoberturaDTO c) {
		Poliza poliza = new Poliza(currentPoliza);
		System.out.println(poliza.toString());
		PolizaDao.savePoliza(poliza);
	}
}
