package DTO;

import Hibernate.Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PolizaDTO{

    private Integer id; //en etapa 4 pone nroPoliza

    private Integer nroPoliza;
    private Integer sumaAsegurada;


    private Siniestros nroSiniestrosAnuales;


    private String estadoPoliza;


    private LocalDate fechaInicioVigencia;


    private LocalDate fechaFinVigencia;


    private String formaDePago;


    private boolean estadoPolizaPdf;


    private Integer premio;


    private Integer derechoDeEmision;


    private Integer descuentos;


    private Integer montoTotal;


    private Integer prima;

    private CambioPoliza cambiosPoliza ;

    private ClienteDTO cliente;

    private CoberturaDTO cobertura;

    private VehiculoDTO vehiculo;

    private LocalidadDTO localidad;

    private List<HijoDTO> hijos = new ArrayList<>();
    private List<MedidaSeguridadDTO> medidas = new ArrayList<>();

    public PolizaDTO() {
    }

    public PolizaDTO(Integer id, Integer sumaAsegurada, Siniestros nroSiniestrosAnuales, String estadoPoliza, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia, String formaDePago, boolean estadoPolizaPdf, Integer premio, Integer derechoDeEmision, Integer descuentos, Integer montoTotal, Integer prima, CambioPoliza cambiosPoliza, ClienteDTO cliente, CoberturaDTO cobertura, VehiculoDTO vehiculo, LocalidadDTO localidad, List<HijoDTO> hijos, List<MedidaSeguridadDTO> medidas) {
        this.id = id;
        this.sumaAsegurada = sumaAsegurada;
        this.nroSiniestrosAnuales = nroSiniestrosAnuales;
        this.estadoPoliza = estadoPoliza;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.formaDePago = formaDePago;
        this.estadoPolizaPdf = estadoPolizaPdf;
        this.premio = premio;
        this.derechoDeEmision = derechoDeEmision;
        this.descuentos = descuentos;
        this.montoTotal = montoTotal;
        this.prima = prima;
        this.cambiosPoliza = cambiosPoliza;
        this.cliente = cliente;
        this.cobertura = cobertura;
        this.vehiculo = vehiculo;
        this.localidad = localidad;
        this.hijos = hijos;
        this.medidas = medidas;
    }

    public PolizaDTO(Poliza poliza) {
        this.id = poliza.getId();
        this.sumaAsegurada = poliza.getSumaAsegurada();
        this.nroSiniestrosAnuales = poliza.getNroSiniestrosAnuales();
        this.estadoPoliza = poliza.getEstadoPoliza();
        this.fechaInicioVigencia = poliza.getFechaInicioVigencia();
        this.fechaFinVigencia = poliza.getFechaFinVigencia();
        this.formaDePago = poliza.getFormaDePago();
        this.estadoPolizaPdf = poliza.isEstadoPolizaPdf();
        this.premio = poliza.getPremio();
        this.derechoDeEmision = poliza.getDerechoDeEmision();
        this.descuentos = poliza.getDescuentos();
        this.montoTotal = poliza.getMontoTotal();
        this.prima = poliza.getPrima();
        this.cambiosPoliza = poliza.getCambiosPoliza();
        this.cliente = new ClienteDTO(poliza.getCliente());
        this.cobertura = new CoberturaDTO(poliza.getCobertura());
        this.vehiculo = new VehiculoDTO(poliza.getVehiculo());
        this.localidad = new LocalidadDTO(poliza.getLocalidad());
        poliza.getHijosPoliza().forEach(hijoPoliza -> this.hijos.add(new HijoDTO(hijoPoliza)));
        poliza.getMedidas().forEach(medidas->this.medidas.add(new MedidaSeguridadDTO(medidas)));
    }

    public Integer getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(Integer nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Integer sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public Siniestros getNroSiniestrosAnuales() {
        return nroSiniestrosAnuales;
    }

    public void setNroSiniestrosAnuales(Siniestros nroSiniestrosAnuales) {
        this.nroSiniestrosAnuales = nroSiniestrosAnuales;
    }

    public String getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(String estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public boolean isEstadoPolizaPdf() {
        return estadoPolizaPdf;
    }

    public void setEstadoPolizaPdf(boolean estadoPolizaPdf) {
        this.estadoPolizaPdf = estadoPolizaPdf;
    }

    public Integer getPremio() {
        return premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

    public Integer getDerechoDeEmision() {
        return derechoDeEmision;
    }

    public void setDerechoDeEmision(Integer derechoDeEmision) {
        this.derechoDeEmision = derechoDeEmision;
    }

    public Integer getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Integer descuentos) {
        this.descuentos = descuentos;
    }

    public Integer getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Integer montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Integer getPrima() {
        return prima;
    }

    public void setPrima(Integer prima) {
        this.prima = prima;
    }

    public CambioPoliza getCambiosPoliza() {
        return cambiosPoliza;
    }

    public void setCambiosPoliza(CambioPoliza cambiosPoliza) {
        this.cambiosPoliza = cambiosPoliza;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public CoberturaDTO getCobertura() {
        return cobertura;
    }

    public void setCobertura(CoberturaDTO cobertura) {
        this.cobertura = cobertura;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalidadDTO getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadDTO localidad) {
        this.localidad = localidad;
    }

    public List<HijoDTO> getHijosPoliza() {
        return hijos;
    }

    public void setHijosPoliza(List<HijoDTO> hijosPoliza) {
        this.hijos = hijosPoliza;
    }

    @Override
    public String toString() {
        return "PolizaDTO{" +
                "id=" + id +
                ", sumaAsegurada=" + sumaAsegurada +
                ", nroSiniestrosAnuales=" + nroSiniestrosAnuales +
                ", estadoPoliza='" + estadoPoliza + '\'' +
                ", fechaInicioVigencia=" + fechaInicioVigencia +
                ", fechaFinVigencia=" + fechaFinVigencia +
                ", formaDePago='" + formaDePago + '\'' +
                ", estadoPolizaPdf=" + estadoPolizaPdf +
                ", premio=" + premio +
                ", derechoDeEmision=" + derechoDeEmision +
                ", descuentos=" + descuentos +
                ", montoTotal=" + montoTotal +
                ", prima=" + prima +
                ", cambiosPoliza=" + cambiosPoliza +
                ", cliente=" + cliente +
                ", cobertura=" + cobertura +
                ", vehiculo=" + vehiculo +
                ", localidad=" + localidad +
                ", hijosPoliza=" + hijos +
                '}';
    }

    public void addHijo(HijoDTO hijoDTO) {
        this.hijos.add(hijoDTO);
    }
    public List<MedidaSeguridadDTO> getMedidasSeguradad() {
        return medidas;
    }

    public void addMedida(MedidaSeguridadDTO garaje) {
        this.medidas.add(garaje);
    }

	public boolean getEstadoPolizaPdf() {
        return estadoPolizaPdf;
	}
}


//tostring
//getter setters


