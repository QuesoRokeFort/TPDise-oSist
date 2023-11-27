package DTO;

import Hibernate.Model.*;

public class MedidaSeguridadDTO{

    private int id;

    private String nombreMedida;

    private Integer valorPorcentual;


    public MedidaSeguridadDTO(int id, String nombreMedida, Integer valorPorcentual) {
        this.id = id;
        this.nombreMedida = nombreMedida;
        this.valorPorcentual = valorPorcentual;
    }

    public MedidaSeguridadDTO(MedidaSeguridad medidaSeguridad) {
        this.id = medidaSeguridad.getId();
        this.nombreMedida = medidaSeguridad.getNombreMedida();
        this.valorPorcentual = medidaSeguridad.getValorPorcentual();
    }

    public MedidaSeguridadDTO() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "MedidaSeguridadDTO{" +
                "id=" + id +
                ", nombreMedida='" + nombreMedida + '\'' +
                ", valorPorcentual=" + valorPorcentual +
                '}';
    }
}


//tostring
//getter setters


