package Gestores;

import DTO.*;
import Hibernate.Dao.*;
import Hibernate.Model.*;

import java.util.List;


public class GestorPoliza {
	public static void crearPoliza(PolizaDTO currentPoliza, LocalidadDTO l, VehiculoDTO vehiculoDTO, CoberturaDTO c) {
		Poliza poliza = new Poliza();
		if(validateDatosVehiculo(vehiculoDTO)) {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setModelo(ModeloDao.getModeloById(vehiculoDTO.getModelo().getId()));
			vehiculo.setAnioFabricacion(AnioFabricacionDao.getAnioFabricacionById(vehiculoDTO.getAnioFabricacion().getId()));
			vehiculo.setChasis(vehiculoDTO.getChasis());
			vehiculo.setMotor(vehiculoDTO.getMotor());
			vehiculo.setPatente(vehiculoDTO.getPatente());
			vehiculo.setKilometrosAnuales(vehiculoDTO.getKilometrosAnuales());
			poliza.setVehiculo(vehiculo);
		}
		currentPoliza.getHijosPoliza().forEach(hijoDTO -> {
			if (validateDatosHijo(hijoDTO)) {
				Hijo hijo = new Hijo();
				hijo.setEstadoCivil(hijo.getEstadoCivil());
				hijo.setSexoHijo(hijoDTO.getSexoHijo());
				hijo.setFechaDeNacimiento(hijoDTO.getFechaDeNacimiento());
				poliza.addHijo(hijo);
			}
		});
		if (validateDatosCobertura()){
			Cobertura cobertura = new Cobertura();
			cobertura.setProveedor(ProveedorDao.getProveedorById(c.getProveedor().getId()));
			cobertura.setTipoCobertura(TipoCoberturaDao.getTipoCoberturaById(c.getTipoCobertura().getId()));
			cobertura.setPrecio(c.getPrecio());
			poliza.setCobertura(cobertura);
		}
		if (currentPoliza.getFormaDePago().equals("Semestral")){
			for (int i = 0; i < 6; i++) {
				Cuota cuota = new Cuota();
				cuota.setImporte(currentPoliza.getCobertura().getPrecio());
				cuota.setUltimoDiaDePago(currentPoliza.getFechaInicioVigencia().plusMonths(i+1));
				cuota.setPoliza(poliza);
				poliza.addCuota(cuota);
			}
		}else{
			Cuota cuota = new Cuota();
			cuota.setImporte(currentPoliza.getCobertura().getPrecio());
			cuota.setUltimoDiaDePago(currentPoliza.getFechaInicioVigencia().plusMonths(1));
			cuota.setPoliza(poliza);
			poliza.addCuota(cuota);
		}
		if (validateDatosPoliza(currentPoliza)) {
			//TODO finish this and more
			poliza.setLocalidad(LocalidadDao.getLocalidadById(currentPoliza.getLocalidad().getId()));
			poliza.setCliente(ClienteDao.getClienteById(currentPoliza.getCliente().getNroCliente()));
			poliza.setEstadoPoliza("Vigente");
			poliza.setNroPoliza(PolizaDao.GenerateNro());
		}
		System.out.println(poliza.toString());
		PolizaDao.savePoliza(poliza);
	}

	private static boolean validateDatosCobertura() {
		//TODO
		return true;
	}

	private static boolean validateDatosHijo(HijoDTO hijoDTO) {
		//TODO
		return true;
	}

	private static boolean validateDatosVehiculo(VehiculoDTO v) {
		//TODO
		return true;
	}

	private static boolean validateDatosPoliza(PolizaDTO currentPoliza) {
		//TODO
		return true;
	}

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
