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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedida")
    private Integer idMedida;

    @Column(name = "nombreMedida", length = 20)
    private String nombreMedida;

    @Column(name = "valorPorcentual")
    private Integer valorPorcentual;

    @ManyToMany
    @JoinTable(
            name = "Poliza_MedidaSeguridad",
            joinColumns = @JoinColumn(name = "idMedida"),
            inverseJoinColumns = @JoinColumn(name = "idPoliza")
    )
    private List<Poliza> polizas;


    public MedidaSeguridad() {
    }

    public MedidaSeguridad(Integer id, String nombreMedida, Integer valorPorcentual) {
        this.idMedida = id;
        this.nombreMedida = nombreMedida;
        this.valorPorcentual = valorPorcentual;
    }
    public MedidaSeguridad(MedidaSeguridadDTO medidaSeguridad) {
        this.nombreMedida = medidaSeguridad.getNombreMedida();
        this.valorPorcentual = medidaSeguridad.getValorPorcentual();
    }

    public Integer getId() {
        return idMedida;
    }

    public void setId(Integer id) {
        this.idMedida = id;
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
                "id=" + idMedida +
                ", nombreMedida='" + nombreMedida + '\'' +
                ", valorPorcentual=" + valorPorcentual +
                '}';
    }
}