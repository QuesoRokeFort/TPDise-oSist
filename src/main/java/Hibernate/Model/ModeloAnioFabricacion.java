package Hibernate.Model;

import DTO.ModeloAnioFabricacionDTO;
import DTO.ModeloDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ModeloAnioFabricacion")
public class ModeloAnioFabricacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "idAnio")
    private AnioFabricacion anio;


    public ModeloAnioFabricacion() {
    }

    public ModeloAnioFabricacion(Integer id, Modelo modelo, AnioFabricacion anio) {
        this.id = id;
        this.modelo = modelo;
        this.anio = anio;
    }

    public ModeloAnioFabricacion(ModeloAnioFabricacionDTO modeloAnioFabricacion) {
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
        return "ModeloAnioFabricacion{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", anio=" + anio +
                '}';
    }
}