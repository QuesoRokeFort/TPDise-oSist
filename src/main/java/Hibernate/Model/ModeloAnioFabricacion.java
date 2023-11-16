package Hibernate.Model;

import DTO.ModeloDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "modelo_anio_fabricacion")
public class ModeloAnioFabricacion {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_anio", referencedColumnName = "id_anio")
    private AnioFabricacion anio;


    public ModeloAnioFabricacion() {
    }

    public ModeloAnioFabricacion(Integer id, Modelo modelo, AnioFabricacion anio) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
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

// Otros campos y métodos getters/setters
}