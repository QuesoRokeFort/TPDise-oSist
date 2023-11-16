package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class VehiculoDTO {

    private int id;

    private String chasis;

    private String patente;

    private int kilometrosAnuales;

    private ModeloDTO modelo;

    private AnioFabricacionDTO anioFabricacion;

    public VehiculoDTO() {

    }

    public VehiculoDTO(int id, String chasis, String patente, int kilometrosAnuales, ModeloDTO modelo, AnioFabricacionDTO anioFabricacion) {
        this.id = id;
        this.chasis = chasis;
        this.patente = patente;
        this.kilometrosAnuales = kilometrosAnuales;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public VehiculoDTO(Vehiculo vehiculo) {
        this.id = vehiculo.getId();
        this.chasis = vehiculo.getChasis();
        this.patente = vehiculo.getPatente();
        this.kilometrosAnuales = vehiculo.getKilometrosAnuales();
        this.modelo = new ModeloDTO(vehiculo.getModelo());
        this.anioFabricacion = new AnioFabricacionDTO(vehiculo.getAnioFabricacion());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getKilometrosAnuales() {
        return kilometrosAnuales;
    }

    public void setKilometrosAnuales(int kilometrosAnuales) {
        this.kilometrosAnuales = kilometrosAnuales;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    public AnioFabricacionDTO getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(AnioFabricacionDTO anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" +
                "id=" + id +
                ", chasis='" + chasis + '\'' +
                ", patente='" + patente + '\'' +
                ", kilometrosAnuales=" + kilometrosAnuales +
                ", modelo=" + modelo +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }


//tostring
    //getter setters

}
