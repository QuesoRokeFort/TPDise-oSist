import Hibernate.Dao.DireccionDao;
import Hibernate.Dao.LocalidadDao;
import Hibernate.Dao.PaisDao;
import Hibernate.Dao.ProvinciaDao;
import Hibernate.Model.*;


import java.util.List;

public class App {
	public static void main(String[] args) {
		/*Localidad localidad = new Localidad();
		localidad.setNombre("Santa Fe");
		localidad.setValorDeRiesgo(10);
		localidad.setProvincia(ProvinciaDao.getProvinciaById(1));
		LocalidadDao.saveLocalidad(localidad);*/
		LocalidadDao.getLocalidades().forEach(l-> System.out.println(l.toString()));
		/*Direccion direccion =new Direccion();
		direccion.setCalle("pedro dias colodrero");
		direccion.setAltura(1645);
		direccion.setPiso("0");
		direccion.setDepto("no");
		direccion.setLocalidad(LocalidadDao.getLocalidadById(1));
		DireccionDao.saveDireccion(direccion);*/
		DireccionDao.getDirecciones().forEach(d-> System.out.println(d.toString()));
	}
}
