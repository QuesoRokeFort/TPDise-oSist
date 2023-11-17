package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ModeloAnioFabricacionDTO{

    private Integer id;

    private Modelo modelo;

    private AnioFabricacion anio;

    public ModeloAnioFabricacionDTO() {
    }

    public ModeloAnioFabricacionDTO(Integer id, Modelo modelo, AnioFabricacion anio) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
    }

    public ModeloAnioFabricacionDTO(ModeloAnioFabricacion modeloAnioFabricacion) {
        this.id = modeloAnioFabricacion.getId();
        this.modelo = modeloAnioFabricacion.getModelo();
        this.anio = modeloAnioFabricacion.getAnio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public AnioFabricacion getAnio() {
        return anio;
    }

    public void setAnio(AnioFabricacion anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "ModeloAnioFabricacionDTO{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", anio=" + anio +
                '}';
    }
}


//tostring
//getter setters


