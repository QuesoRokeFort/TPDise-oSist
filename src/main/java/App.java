import Hibernate.Dao.PaisDao;
import Hibernate.Dao.ProvinciaDao;
import Hibernate.Model.*;


import java.util.List;

public class App {
	public static void main(String[] args) {
		Provincia pr = new Provincia();
		pr.setNombre("Santa Fe");
		pr.setCodPostal(3000);
		PaisDao paisDao = new PaisDao();
		PaisDao pd = new PaisDao();;
		pr.setPais(pd.getPaisById((long)1));
		ProvinciaDao prd = new ProvinciaDao();
		prd.saveProvincia(pr);

		//paisDao.savePais(p);
		List<Pais> paises = paisDao.getPaises();
		paises.forEach(pais -> System.out.println(pais.toString()));
		/*for (int i = 0; i < paises.size(); i++) {
			System.out.println(;paises.get(i).toString());
		}*/

		List<Provincia> provincias = prd.getProvincias();
		provincias.forEach(provincia -> System.out.println(provincia.toString()));
	}
}
