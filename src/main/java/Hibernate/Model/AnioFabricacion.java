package Hibernate.Model;


import DTO.AnioFabricacionDTO;
import DTO.DireccionDTO;
import DTO.VehiculoDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AñoFabricacion")
public class AnioFabricacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "anio")
    private Integer anio;

    public AnioFabricacion() {
    }

    public AnioFabricacion(Integer id, Integer anio) {
        this.id = id;
        this.anio = anio;
    }

    public AnioFabricacion(AnioFabricacionDTO anioFabricacion) {
        this.id = anioFabricacion.getId();
        this.anio = anioFabricacion.getAnio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "AnioFabricacion{" +
                "id=" + id +
                ", anio=" + anio +
                '}';
    }
}
