package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ProveedorDTO{

    private int id;

    private String nombreProv;

    public ProveedorDTO() {
    }

    public ProveedorDTO(int id, String nombreProv) {
        this.id = id;
        this.nombreProv = nombreProv;
    }

    public ProveedorDTO(Proveedor proveedor) {
        this.id = proveedor.getId();
        this.nombreProv = proveedor.getNombreProv();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    @Override
    public String toString() {
        return "ProveedorDTO{" +
                "id=" + id +
                ", nombreProv='" + nombreProv + '\'' +
                '}';
    }
}


//tostring
//getter setters


