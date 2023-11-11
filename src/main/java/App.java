import Hibernate.Dao.PaisDao;
import Hibernate.Model.Pais;

import java.util.List;

public class App {
	public static void main(String[] args) {
		//Pais p = new Pais();
		//p.setNombre("Brasil");

		PaisDao paisDao = new PaisDao();
		//paisDao.savePais(p);
		List<Pais> paises = paisDao.getPaises();
		paises.forEach(pais -> System.out.println(pais.toString()));
		/*for (int i = 0; i < paises.size(); i++) {
			System.out.println(;paises.get(i).toString());
		}*/
	}
}
