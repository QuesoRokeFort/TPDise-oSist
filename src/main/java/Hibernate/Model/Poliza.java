package Hibernate.Model;

import DTO.PolizaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Poliza")
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //en etapa 4 pone nroPoliza

    // saque derechosEmision asumiendo que era lo mismo que derechoDeEmision

    @Column(name = "sumaAsegurada")
    private Integer sumaAsegurada;

    @Column(name = "nroSiniestrosAnuales")
    private Integer nroSiniestrosAnuales;

    @Column(name = "estadoPoliza", length = 20)
    private String estadoPoliza;

    @Column(name = "fechaInicioVigencia")
    private Date fechaInicioVigencia;

    @Column(name = "fechaFinVigencia")
    private Date fechaFinVigencia;

    @Column(name = "formaDePago", length = 20)
    private String formaDePago;

    @Column(name = "estadoPolizaPdf")
    private boolean estadoPolizaPdf;

    @Column(name = "premio")
    private Integer premio;

    @Column(name = "derechoDeEmision")
    private Integer derechoDeEmision;

    @Column(name = "descuentos")
    private Integer descuentos;

    @Column(name = "montoTotal")
    private Integer montoTotal;

    @Column(name = "prima")
    private Integer prima;


    @OneToMany(mappedBy = "poliza", cascade = CascadeType.ALL, orphanRemoval = true) // cambio Etapa 4 segun profe
    private List<CambioPoliza> cambiosPoliza = new ArrayList<>();                   // antes era OneToOne

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCobertura", unique = true)
    private Cobertura cobertura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVehiculo", unique = true)
    private Vehiculo vehiculo;

    @ManyToOne                                    //cambio Etapa 4 segun profe, antes era Direccion
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;

    @OneToMany(mappedBy = "poliza", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HijoPoliza> hijosPoliza = new ArrayList<>();


    public Poliza() {
    }

    public Poliza(Integer id, Integer sumaAsegurada, Integer nroSiniestrosAnuales, String estadoPoliza, Date fechaInicioVigencia, Date fechaFinVigencia, String formaDePago, boolean estadoPolizaPdf, Integer premio, Integer derechoDeEmision, Integer descuentos, Integer montoTotal, Integer prima, List<CambioPoliza> cambiosPoliza, Cliente cliente, Cobertura cobertura, Vehiculo vehiculo, Localidad localidad, List<HijoPoliza> hijosPoliza) {
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
        this.hijosPoliza = hijosPoliza;
    }

    public Poliza(PolizaDTO poliza) {
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
        this.cliente = poliza.getCliente();
        this.cobertura = poliza.getCobertura();
        this.vehiculo = poliza.getVehiculo();
        this.localidad = poliza.getLocalidad();
        this.hijosPoliza = poliza.getHijosPoliza();
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

    public Integer getNroSiniestrosAnuales() {
        return nroSiniestrosAnuales;
    }

    public void setNroSiniestrosAnuales(Integer nroSiniestrosAnuales) {
        this.nroSiniestrosAnuales = nroSiniestrosAnuales;
    }

    public String getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(String estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
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


    public List<CambioPoliza> getCambiosPoliza() {
        return cambiosPoliza;
    }

    public void setCambiosPoliza(List<CambioPoliza> cambiosPoliza) {
        this.cambiosPoliza = cambiosPoliza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<HijoPoliza> getHijosPoliza() {
        return hijosPoliza;
    }

    public void setHijosPoliza(List<HijoPoliza> hijosPoliza) {
        this.hijosPoliza = hijosPoliza;
    }

    @Override
    public String toString() {
        return "Poliza{" +
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
                ", hijosPoliza=" + hijosPoliza +
                '}';
    }
}