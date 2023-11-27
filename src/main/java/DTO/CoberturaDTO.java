package DTO;

import Hibernate.Model.*;


public class CoberturaDTO {

    private Integer id;

    private TipoCobertura tipoCobertura;

    private Proveedor proveedor;

    private String ajusteSiniestro;

    private Integer ajustePorKm;

    private Integer ajusteCantHijos;
    private Integer precio;

    public CoberturaDTO() {
    }

    public CoberturaDTO(Integer id, TipoCobertura tipoCobertura, Proveedor proveedor, String ajusteSiniestro, Integer ajustePorKm, Integer ajusteCantHijos, Integer precio) {
        this.id = id;
        this.tipoCobertura = tipoCobertura;
        this.proveedor = proveedor;
        this.ajusteSiniestro = ajusteSiniestro;
        this.ajustePorKm = ajustePorKm;
        this.ajusteCantHijos = ajusteCantHijos;
        this.precio = precio;
    }

    public CoberturaDTO(Cobertura cobertura) {
        this.id = cobertura.getId();
        this.tipoCobertura = cobertura.getTipoCobertura();
        this.proveedor = cobertura.getProveedor();
        this.ajusteSiniestro = cobertura.getAjusteSiniestro();
        this.ajustePorKm = cobertura.getAjustePorKm();
        this.ajusteCantHijos = cobertura.getAjusteCantHijos();
        this.precio = cobertura.getPrecio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getAjusteSiniestro() {
        return ajusteSiniestro;
    }

    public void setAjusteSiniestro(String ajusteSiniestro) {
        this.ajusteSiniestro = ajusteSiniestro;
    }

    public Integer getAjustePorKm() {
        return ajustePorKm;
    }

    public void setAjustePorKm(Integer ajustePorKm) {
        this.ajustePorKm = ajustePorKm;
    }

    public Integer getAjusteCantHijos() {
        return ajusteCantHijos;
    }

    public void setAjusteCantHijos(Integer ajusteCantHijos) {
        this.ajusteCantHijos = ajusteCantHijos;
    }

    @Override
    public String toString() {
        return "CoberturaDTO{" +
                "id=" + id +
                ", tipoCobertura=" + tipoCobertura +
                ", proveedor=" + proveedor +
                ", ajusteSiniestro='" + ajusteSiniestro + '\'' +
                ", ajustePorKm=" + ajustePorKm +
                ", ajusteCantHijos=" + ajusteCantHijos +
                '}';
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}

//tostring
//getter setters


