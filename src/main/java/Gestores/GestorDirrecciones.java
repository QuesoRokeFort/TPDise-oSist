package Gestores;

import DTO.LocalidadDTO;
import DTO.PaisDTO;
import DTO.ProvinciaDTO;
import Hibernate.Dao.LocalidadDao;
import Hibernate.Dao.PaisDao;
import Hibernate.Dao.ProvinciaDao;
import Hibernate.Model.Pais;

import java.util.ArrayList;
import java.util.List;

public class GestorDirrecciones {
	public static List<PaisDTO>  getPaises(){
		List<PaisDTO> paisDTOS = new ArrayList<>();
		PaisDao.getPaises().forEach(pais -> paisDTOS.add(new PaisDTO(pais)));
		return  paisDTOS;
	}

	public static List<ProvinciaDTO> getProvinciasByPais(PaisDTO paisElegido) {
		Pais pais =	PaisDao.getPaisById(paisElegido.getId());
		List<ProvinciaDTO> provinciaDTOS = new ArrayList<>();
		ProvinciaDao.getProvinciasByPais(pais).forEach(provincia -> provinciaDTOS.add(new ProvinciaDTO(provincia)));
		return provinciaDTOS;
	}

	public static List<ProvinciaDTO> getProvincias() {
		List<ProvinciaDTO> provinciaDTOS = new ArrayList<>();
		ProvinciaDao.getProvincias().forEach(provincia -> provinciaDTOS.add(new ProvinciaDTO(provincia)));
		return provinciaDTOS;
	}

	public static List<LocalidadDTO> getLocalidades() {
		List<LocalidadDTO> localidadDTO = new ArrayList<>();
		LocalidadDao.getLocalidades().forEach(localidad -> localidadDTO.add(new LocalidadDTO(localidad)));
		return localidadDTO;
	}

	public static List<LocalidadDTO> getLocalidadesByProvincia(ProvinciaDTO selectedProvObject) {
		List<LocalidadDTO> localidadDTOS = new ArrayList<>();
		LocalidadDao.getLocalidadesByProvincia(selectedProvObject.getId()).stream().forEach(localidad -> localidadDTOS.add(new LocalidadDTO(localidad)));
		return localidadDTOS;
	}
}
