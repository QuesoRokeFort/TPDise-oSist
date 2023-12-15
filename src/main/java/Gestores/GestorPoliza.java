package Gestores;

import DTO.*;
import Hibernate.Dao.*;
import Hibernate.Model.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public class GestorPoliza {
	private static final String NUMERO_SUCURSAR = "0001";

	public static void crearPoliza(PolizaDTO currentPoliza, LocalidadDTO l, VehiculoDTO vehiculoDTO, CoberturaDTO c) {
		Poliza poliza = new Poliza();
		System.out.println(currentPoliza);
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
			if (validateHijoDTO(hijoDTO)) {
				Hijo hijo = new Hijo();
				hijo.setEstadoCivil(hijo.getEstadoCivil());
				hijo.setSexoHijo(hijoDTO.getSexoHijo());
				hijo.setFechaDeNacimiento(hijoDTO.getFechaDeNacimiento());
				hijo.setPoliza(poliza);
				poliza.addHijo(hijo);
			}
		});


		if (validateDatosCobertura(c)){
			Cobertura cobertura = new Cobertura();
			cobertura.setProveedor(ProveedorDao.getProveedorById(c.getProveedor().getId()));
			cobertura.setTipoCobertura(TipoCoberturaDao.getTipoCoberturaById(c.getTipoCobertura().getId()));
			cobertura.setPrecio(c.getPrecio());
			cobertura.setAjusteCantHijos(c.getAjusteCantHijos());
			cobertura.setAjusteSiniestro(c.getAjusteSiniestro());
			cobertura.setAjustePorKm(c.getAjustePorKm());
			poliza.setCobertura(cobertura);
		}

		int cantidadDeCuotas = 1;
		if (currentPoliza.getFormaDePago().equals("Semestral")){
			cantidadDeCuotas=6;
		}

		for (int i = 0; i < cantidadDeCuotas; i++) {
			Cuota cuota = new Cuota();
			cuota.setImporte(c.getPrecio());
			cuota.setUltimoDiaDePago(currentPoliza.getFechaInicioVigencia().plusMonths(i+1));
			cuota.setPoliza(poliza);
			poliza.addCuota(cuota);
		}

		currentPoliza.setNroPoliza(generarNroPoliza(vehiculoDTO,currentPoliza));
		currentPoliza.getMedidasSeguradad().forEach(m->{
			MedidaSeguridad medidaSeguridad = new MedidaSeguridad();
			medidaSeguridad.setValorPorcentual(m.getValorPorcentual());
			medidaSeguridad.setNombreMedida(m.getNombreMedida());
			medidaSeguridad.setPoliza(poliza);
			poliza.addMedidas(medidaSeguridad);
		});
		if (validatePolizaDTO(currentPoliza)) {
			poliza.setDerechoDeEmision(currentPoliza.getDerechoDeEmision());
			poliza.setFormaDePago(currentPoliza.getFormaDePago());
			poliza.setDescuentos(currentPoliza.getDescuentos());
			poliza.setEstadoPolizaPdf(currentPoliza.isEstadoPolizaPdf());
			poliza.setPrima(currentPoliza.getPrima());
			poliza.setPremio(currentPoliza.getPremio());
			poliza.setSumaAsegurada(currentPoliza.getSumaAsegurada());
			poliza.setNroSiniestrosAnuales(currentPoliza.getNroSiniestrosAnuales());
			poliza.setMontoTotal(currentPoliza.getMontoTotal());
			poliza.setFechaInicioVigencia(currentPoliza.getFechaInicioVigencia());
			poliza.setFechaFinVigencia(currentPoliza.getFechaFinVigencia());
			poliza.setLocalidad(LocalidadDao.getLocalidadById(l.getId()));
			poliza.setCliente(ClienteDao.getClienteById(currentPoliza.getCliente().getNroCliente()));
			if(CalcularEstado(poliza.getCliente(),currentPoliza.getNroSiniestrosAnuales())){
				poliza.getCliente().setEstadoCliente("Plata");
			}else{
				poliza.getCliente().setEstadoCliente("Normal");
			}
			poliza.setEstadoPoliza("Vigente");
			poliza.setEstadoPolizaPdf(true);
			poliza.setNroPoliza(currentPoliza.getNroPoliza());
		}
		System.out.println(poliza.toString());
		PolizaDao.savePoliza(poliza);
	}

	private static boolean CalcularEstado(Cliente cliente, Siniestros nroSiniestrosAnuales) {
		boolean plata=false;
		int currentYear = Year.now().getValue();
		if (currentYear-cliente.getAnioRegistro() >=2 && nroSiniestrosAnuales.equals(Siniestros.CERO) && EstadoCuotas(cliente)){
			plata=true;
		}
	return plata;
	}
	private static boolean EstadoCuotas (Cliente cliente){
		//TODO A IMPLEMENTAR CUANDO ESTE ESCHO LA PARTE DE CUOTAS
		return true;
	}


	private static String generarNroPoliza(VehiculoDTO vehiculoDTO, PolizaDTO currentPoliza) {
		String nroPoliza = "";
		nroPoliza+= GestorPoliza.getNumeroSucursal();
		nroPoliza+="-";
		nroPoliza+= GestorPoliza.solicitudPoliza(vehiculoDTO,currentPoliza);
		nroPoliza+="-";
		nroPoliza+= GestorPoliza.generarNroRenovacion(currentPoliza.getCliente());
		return nroPoliza;
	}

	private static String generarNroRenovacion(ClienteDTO cliente) {
		//TODO
		return "00";
	}

	private static String solicitudPoliza(VehiculoDTO vehiculoDTO, PolizaDTO currentPoliza) {
		//TODO
		return "0000000";
	}

	private static String getNumeroSucursal() {
		return NUMERO_SUCURSAR;
	}

	private static boolean validateDatosCobertura(CoberturaDTO cobertura) {
		if (cobertura == null) {
			throw new IllegalArgumentException("La cobertura no puede ser nula");
		}

		if (cobertura.getTipoCobertura() == null) {
			throw new IllegalArgumentException("El tipo de cobertura no puede ser nulo");
		}

		if (cobertura.getProveedor() == null) {
			throw new IllegalArgumentException("El proveedor no puede ser nulo");
		}

		if (cobertura.getAjusteSiniestro() == null || cobertura.getAjusteSiniestro().isEmpty()) {
			throw new IllegalArgumentException("El ajuste de siniestro no puede ser nulo o vacío");
		}

		if (cobertura.getAjustePorKm() == null || cobertura.getAjustePorKm() < 0) {
			throw new IllegalArgumentException("El ajuste por kilómetro debe ser un valor no negativo");
		}

		if (cobertura.getAjusteCantHijos() == null || cobertura.getAjusteCantHijos() < 0) {
			throw new IllegalArgumentException("El ajuste de cantidad de hijos debe ser un valor no negativo");
		}

		if (cobertura.getPrecio() == null || cobertura.getPrecio() < 0) {
			throw new IllegalArgumentException("El precio debe ser un valor no negativo");
		}

		return true;
	}

	public static boolean validateHijoDTO(HijoDTO hijoDTO) {
		if (hijoDTO == null) {
			throw new IllegalArgumentException("El objeto HijoDTO no puede ser nulo");
		}

		if (hijoDTO.getFechaDeNacimiento() == null) {
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
		}

		if (hijoDTO.getSexoHijo() == null) {
			throw new IllegalArgumentException("El sexo del hijo no puede ser nulo");
		}

		if (hijoDTO.getEstadoCivil() == null) {
			throw new IllegalArgumentException("El estado civil no puede ser nulo");
		}

		// Puedes agregar más validaciones según sea necesario

		// Si todas las validaciones pasan, retorna true
		return true;
	}

	private static boolean validateDatosVehiculo(VehiculoDTO vehiculoDTO) {
			if (vehiculoDTO == null) {
				throw new IllegalArgumentException("El objeto VehiculoDTO no puede ser nulo");
			}

			if (vehiculoDTO.getChasis() == null || vehiculoDTO.getChasis().isEmpty()) {
				throw new IllegalArgumentException("El chasis no puede ser nulo o vacío");
			}


			if (vehiculoDTO.getKilometrosAnuales() < 0) {
				throw new IllegalArgumentException("Los kilómetros anuales deben ser un valor no negativo");
			}

			if (vehiculoDTO.getModelo() == null || !validateModeloDTO(vehiculoDTO.getModelo())) {
				throw new IllegalArgumentException("El modelo del vehículo no es válido");
			}

			if (vehiculoDTO.getAnioFabricacion() == null || !validateAnioFabricacionDTO(vehiculoDTO.getAnioFabricacion())) {
				throw new IllegalArgumentException("El año de fabricación del vehículo no es válido");
			}

			if (vehiculoDTO.getMotor() == null || vehiculoDTO.getMotor().isEmpty()) {
				throw new IllegalArgumentException("El motor no puede ser nulo o vacío");
			}

			// Puedes agregar más validaciones según sea necesario

			// Si todas las validaciones pasan, retorna true
			return true;
		}

	public static boolean validateModeloDTO(ModeloDTO modeloDTO) {
		if (modeloDTO == null) {
			throw new IllegalArgumentException("El objeto ModeloDTO no puede ser nulo");
		}

		if (modeloDTO.getNombreModelo() == null || modeloDTO.getNombreModelo().isEmpty()) {
			throw new IllegalArgumentException("El nombre del modelo no puede ser nulo o vacío");
		}

		if (modeloDTO.getValorPorcentualRiesgo() == null || modeloDTO.getValorPorcentualRiesgo() < 0) {
			throw new IllegalArgumentException("El valor porcentual de riesgo debe ser un valor no negativo");
		}

		if (modeloDTO.getMarca() == null) {
			throw new IllegalArgumentException("La marca no puede ser nula");
		}

		// Puedes agregar más validaciones según sea necesario

		// Si todas las validaciones pasan, retorna true
		return true;
	}

	public static boolean validateAnioFabricacionDTO(AnioFabricacionDTO anioFabricacionDTO) {
		if (anioFabricacionDTO == null) {
			throw new IllegalArgumentException("El objeto AnioFabricacionDTO no puede ser nulo");
		}

		if (anioFabricacionDTO.getAnio() == null || anioFabricacionDTO.getAnio() <= 0) {
			throw new IllegalArgumentException("El año de fabricación debe ser un valor positivo");
		}

		// Puedes agregar más validaciones según sea necesario

		// Si todas las validaciones pasan, retorna true
		return true;
	}

	public static boolean validatePolizaDTO(PolizaDTO polizaDTO) {
		if (polizaDTO == null) {
			throw new IllegalArgumentException("El objeto PolizaDTO no puede ser nulo");
		}

		if (polizaDTO.getNroPoliza() == null|| polizaDTO.getNroPoliza().isEmpty()){
			throw new IllegalArgumentException("El número de póliza no puede ser nulo");
		}

		if (polizaDTO.getSumaAsegurada() == null || polizaDTO.getSumaAsegurada() < 0) {
			throw new IllegalArgumentException("La suma asegurada debe ser un valor no negativo");
		}

		if (polizaDTO.getNroSiniestrosAnuales() == null ) {
			throw new IllegalArgumentException("El número de siniestros anuales debe ser un valor no negativo");
		}

		if (polizaDTO.getEstadoPoliza() == null || polizaDTO.getEstadoPoliza().isEmpty()) {
			throw new IllegalArgumentException("El estado de la póliza no puede ser nulo o vacío");
		}

		if (polizaDTO.getFechaInicioVigencia() == null || polizaDTO.getFechaFinVigencia() == null) {
			throw new IllegalArgumentException("Las fechas de inicio y fin de vigencia no pueden ser nulas");
		}

		if (polizaDTO.getFechaInicioVigencia().isAfter(polizaDTO.getFechaFinVigencia())) {
			throw new IllegalArgumentException("La fecha de inicio de vigencia debe ser anterior a la fecha de fin de vigencia");
		}

		if (polizaDTO.getFormaDePago() == null || polizaDTO.getFormaDePago().isEmpty()) {
			throw new IllegalArgumentException("La forma de pago no puede ser nula o vacía");
		}

		// Puedes agregar más validaciones según sea necesario

		// Validación de objetos relacionados
		if (polizaDTO.getCliente() == null || !validateClienteDTO(polizaDTO.getCliente())) {
			throw new IllegalArgumentException("El cliente de la póliza no es válido");
		}


		for (MedidaSeguridadDTO medida : polizaDTO.getMedidasSeguradad()) {
			if (medida == null || !validateMedidaSeguridadDTO(medida)) {
				throw new IllegalArgumentException("Una de las medidas de seguridad de la póliza no es válida");
			}
		}

		return true;
	}

	public static boolean validateClienteDTO(ClienteDTO clienteDTO) {
		if (clienteDTO == null) {
			throw new IllegalArgumentException("El objeto ClienteDTO no puede ser nulo");
		}

		if (clienteDTO.getNroCliente() == null || clienteDTO.getNroCliente() <= 0) {
			throw new IllegalArgumentException("El número de cliente debe ser un valor positivo");
		}

		if (clienteDTO.getCondicionIva() == null || clienteDTO.getCondicionIva().isEmpty()) {
			throw new IllegalArgumentException("La condición de IVA no puede ser nula o vacía");
		}

		if (clienteDTO.getMail() == null || clienteDTO.getMail().isEmpty()) {
			throw new IllegalArgumentException("El correo electrónico no puede ser nulo o vacío");
		}

		if (clienteDTO.getAnioRegistro() == null || clienteDTO.getAnioRegistro() <= 0) {
			throw new IllegalArgumentException("El año de registro debe ser un valor positivo");
		}

		if (clienteDTO.getEstadoCliente() == null || clienteDTO.getEstadoCliente().isEmpty()) {
			throw new IllegalArgumentException("El estado del cliente no puede ser nulo o vacío");
		}

		if (clienteDTO.getNroSiniestros() == null || clienteDTO.getNroSiniestros() < 0) {
			throw new IllegalArgumentException("El número de siniestros debe ser un valor no negativo");
		}

		return true;
	}

	public static boolean validateLocalidadDTO(LocalidadDTO localidadDTO) {
		if (localidadDTO == null) {
			throw new IllegalArgumentException("El objeto LocalidadDTO no puede ser nulo");
		}

		if (localidadDTO.getNombre() == null || localidadDTO.getNombre().isEmpty()) {
			throw new IllegalArgumentException("El nombre de la localidad no puede ser nulo o vacío");
		}

		if (localidadDTO.getValorDeRiesgo() < 0) {
			throw new IllegalArgumentException("El valor de riesgo debe ser un valor no negativo");
		}

		return true;
	}

	public static boolean validateMedidaSeguridadDTO(MedidaSeguridadDTO medidaSeguridadDTO) {
		if (medidaSeguridadDTO == null) {
			throw new IllegalArgumentException("El objeto MedidaSeguridadDTO no puede ser nulo");
		}

		if (medidaSeguridadDTO.getNombreMedida() == null || medidaSeguridadDTO.getNombreMedida().isEmpty()) {
			throw new IllegalArgumentException("El nombre de la medida de seguridad no puede ser nulo o vacío");
		}

		if (medidaSeguridadDTO.getValorPorcentual() == null || medidaSeguridadDTO.getValorPorcentual() < 0) {
			throw new IllegalArgumentException("El valor porcentual debe ser un valor no negativo");
		}

		// Puedes agregar más validaciones según sea necesario

		// Si todas las validaciones pasan, retorna true
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

	public static List<ModeloDTO> getModelosByMarca(MarcaDTO marcaDTO) {
		List<ModeloDTO> modelos = new ArrayList<>();
		ModeloDao.getModelosByMarca(marcaDTO.getId()).forEach(m->modelos.add(new ModeloDTO(m)));
		return modelos;
	}

	public static Integer calcularSumaAsegurada(VehiculoDTO vehiculoDTO) {
		return 0;
	}

	public static Integer calcularDerechoEmision() {
		return 0;
	}
	public static Integer calcularPrima(CoberturaDTO coberturaDTO, LocalidadDTO localidad, VehiculoDTO vehiculo, List<MedidaSeguridadDTO> medidaSeguridads, Siniestros nroSiniestrosAnuales, List<HijoDTO> hijosPoliza){
		return 0;
	}

	public static Integer calcularDescuentos(List<MedidaSeguridadDTO> medidasSeguradad, ClienteDTO cliente, String formaDePago) {
		return 0;
	}

	public static Integer calcularPremio(Integer derechoDeEmision, Integer prima) {
		return 0;
	}

	public static List<AnioFabricacionDTO> getañosByModelo(ModeloDTO modeloDTO) {
		List<AnioFabricacionDTO> anio = new ArrayList<>();
		ModeloAnioFabricacionDao.getAñoByModelo(modeloDTO).forEach(modeloAnioFabricacion -> {
			anio.add(new AnioFabricacionDTO(modeloAnioFabricacion.getAnio()));
		});
		return anio;
	}

	public static String calcularAjusteSiniestro(Siniestros nroSiniestrosAnuales) {
		return "cero";
	}
}
