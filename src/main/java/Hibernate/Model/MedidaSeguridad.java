package Hibernate.Model;

import DTO.MedidaSeguridadDTO;
import DTO.ModeloDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "MedidaSeguridad")
public class MedidaSeguridad {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreMedida", length = 20)
    private String nombreMedida;

    @Column(name = "valorPorcentual")
    private Integer valorPorcentual;
    @ManyToOne
    @JoinColumn(name = "poliza_id") // This is the foreign key column in the MedidaSeguridad table
    private Poliza poliza;
    public MedidaSeguridad() {
    }

    public MedidaSeguridad(Integer id, String nombreMedida, Integer valorPorcentual) {
        this.id = id;
        this.nombreMedida = nombreMedida;
        this.valorPorcentual = valorPorcentual;
    }
    public MedidaSeguridad(MedidaSeguridadDTO medidaSeguridad) {
        this.id = medidaSeguridad.getId();
        this.nombreMedida = medidaSeguridad.getNombreMedida();
        this.valorPorcentual = medidaSeguridad.getValorPorcentual();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMedida() {
        return nombreMedida;
    }

    public void setNombreMedida(String nombreMedida) {
        this.nombreMedida = nombreMedida;
    }

    public Integer getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(Integer valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    @Override
    public String toString() {
        return "MedidaSeguridad{" +
                "id=" + id +
                ", nombreMedida='" + nombreMedida + '\'' +
                ", valorPorcentual=" + valorPorcentual +
                '}';
    }

}