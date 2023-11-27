package Gestores;

import DTO.PolizaDTO;
import Hibernate.Dao.PolizaDao;
import Hibernate.Model.Poliza;

public class GestorPoliza {
	public static void crearPoliza(PolizaDTO currentPoliza) {
		Poliza poliza = new Poliza(currentPoliza);
		System.out.println(poliza.toString());
		PolizaDao.savePoliza(poliza);
	}
}
