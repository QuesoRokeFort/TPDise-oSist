package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AnioFabricacionDTO {

    private int id;
    private Integer anio;

    public AnioFabricacionDTO() {
    }

    public AnioFabricacionDTO(int id, Integer anio) {
        this.id = id;
        this.anio = anio;
    }

    public AnioFabricacionDTO(AnioFabricacion anioFabricacion) {
        this.id = anioFabricacion.getId();
        this.anio = anioFabricacion.getAnio();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "AnioFabricacionDTO{" +
                "id=" + id +
                ", anio=" + anio +
                '}';
    }

    //tostring
    //getter setters

}
