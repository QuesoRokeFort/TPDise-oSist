package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class TipoCoberturaDTO {

    private int id;

    private String nombreTipo;

    public TipoCoberturaDTO() {
    }

    public TipoCoberturaDTO(int id, String nombreTipo) {
        this.id = id;
        this.nombreTipo = nombreTipo;
    }
    public TipoCoberturaDTO(TipoCobertura tipoCobertura) {
        this.id = tipoCobertura.getId();
        this.nombreTipo = tipoCobertura.getNombreTipo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}

    //tostring
    //getter setters


