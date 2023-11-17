package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CambioPolizaDTO{

    private Integer id;

    private String patente;

    private String motor;

    private String chasis;

    private Integer kmAnio;

    private Integer siniestrosAnio;

    private TipoCobertura tipoCobertura;

    public CambioPolizaDTO() {
    }

    public CambioPolizaDTO(Integer id, String patente, String motor, String chasis, Integer kmAnio, Integer siniestrosAnio, TipoCobertura tipoCobertura) {
        this.id = id;
        this.patente = patente;
        this.motor = motor;
        this.chasis = chasis;
        this.kmAnio = kmAnio;
        this.siniestrosAnio = siniestrosAnio;
        this.tipoCobertura = tipoCobertura;
    }

    public CambioPolizaDTO(CambioPoliza cambioPoliza) {
        this.id = cambioPoliza.getId();
        this.patente = cambioPoliza.getPatente();
        this.motor = cambioPoliza.getMotor();
        this.chasis = cambioPoliza.getChasis();
        this.kmAnio = cambioPoliza.getKmAnio();
        this.siniestrosAnio = cambioPoliza.getSiniestrosAnio();
        this.tipoCobertura = cambioPoliza.getTipoCobertura();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public Integer getKmAnio() {
        return kmAnio;
    }

    public void setKmAnio(Integer kmAnio) {
        this.kmAnio = kmAnio;
    }

    public Integer getSiniestrosAnio() {
        return siniestrosAnio;
    }

    public void setSiniestrosAnio(Integer siniestrosAnio) {
        this.siniestrosAnio = siniestrosAnio;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    @Override
    public String toString() {
        return "CambioPolizaDTO{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", motor='" + motor + '\'' +
                ", chasis='" + chasis + '\'' +
                ", kmAnio=" + kmAnio +
                ", siniestrosAnio=" + siniestrosAnio +
                ", tipoCobertura=" + tipoCobertura +
                '}';
    }
}


//tostring
//getter setters


