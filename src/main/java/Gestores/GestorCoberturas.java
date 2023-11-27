package Gestores;

import DTO.CoberturaDTO;
import DTO.PrecioProveedorTipoDTO;
import Hibernate.Dao.CoberturaDao;
import Hibernate.Dao.PrecioProveedorTipoDao;

import java.util.ArrayList;
import java.util.List;

public class GestorCoberturas {
	public static List<CoberturaDTO> getCoberturas() {
		List<CoberturaDTO> coberturas = new ArrayList<>();
		CoberturaDao.getCoberturas().forEach(cobertura -> coberturas.add(new CoberturaDTO(cobertura)));
		return coberturas;
	}

	public static List<PrecioProveedorTipoDTO> getPrecios() {
		List<PrecioProveedorTipoDTO> precios = new ArrayList<>();
		PrecioProveedorTipoDao.getPreciosProveedoresTipos().forEach(precio-> precios.add(new PrecioProveedorTipoDTO(precio)));
		return precios;
	}
}
