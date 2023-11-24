package GestorPersonas;

import DTO.AnioFabricacionDTO;
import DTO.MarcaDTO;
import DTO.ModeloDTO;
import Hibernate.Dao.AnioFabricacionDao;
import Hibernate.Dao.MarcaDao;
import Hibernate.Dao.ModeloDao;

import java.util.ArrayList;
import java.util.List;

public class GestorVehiculos {
	public static List<ModeloDTO> getModelos() {
		List<ModeloDTO> modelos;
		modelos =ModeloDao.getModelos().stream().map(modelo -> new ModeloDTO(modelo)).toList();
		return modelos;
	}

	public static List<MarcaDTO> getMarcas() {
		List<MarcaDTO> marcas;
		marcas = MarcaDao.getMarcas().stream().map(marca -> new MarcaDTO(marca)).toList();
		return marcas;
	}

	public static List<AnioFabricacionDTO> getAños() {
		List<AnioFabricacionDTO> años;
		años = AnioFabricacionDao.getAniosFabricacion().stream().map(anio -> new AnioFabricacionDTO(anio)).toList();
		return años;
	}
}
