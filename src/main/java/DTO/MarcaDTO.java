package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class MarcaDTO {

    private int id;

    private String nombreMarca;

    public MarcaDTO() {
    }

    public MarcaDTO(int id, String nombreMarca) {
        this.id = id;
        this.nombreMarca = nombreMarca;
    }

    public MarcaDTO(Marca marca) {
        this.id = marca.getId();
        this.nombreMarca = marca.getNombreMarca();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    @Override
    public String toString() {
        return "MarcaDTO{" +
                "id=" + id +
                ", nombreMarca='" + nombreMarca + '\'' +
                '}';
    }


//tostring
    //getter setters

}
