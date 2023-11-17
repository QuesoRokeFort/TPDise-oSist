package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
public class MedidaPolizaDTO{

    private int id;

    private MedidaSeguridad medidaSeguridad;

    private Poliza poliza;


    public MedidaPolizaDTO() {
    }

    public MedidaPolizaDTO(int id, MedidaSeguridad medidaSeguridad, Poliza poliza) {
        this.id = id;
        this.medidaSeguridad = medidaSeguridad;
        this.poliza = poliza;
    }

    public MedidaPolizaDTO(MedidaPoliza medidaPoliza) {
        this.id = medidaPoliza.getId();
        this.medidaSeguridad = medidaPoliza.getMedidaSeguridad();
        this.poliza = medidaPoliza.getPoliza();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedidaSeguridad getMedidaSeguridad() {
        return medidaSeguridad;
    }

    public void setMedidaSeguridad(MedidaSeguridad medidaSeguridad) {
        this.medidaSeguridad = medidaSeguridad;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    @Override
    public String toString() {
        return "MedidaPolizaDTO{" +
                "id=" + id +
                ", medidaSeguridad=" + medidaSeguridad +
                ", poliza=" + poliza +
                '}';
    }
}


//tostring
//getter setters


