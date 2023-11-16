package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ModeloDTO {

    private int id;

    private String nombreModelo;

    private String motor;

    private Integer valorPorcentualRiesgo;

    private Marca marca;

    public ModeloDTO() {
    }

    public ModeloDTO(int id, String nombreModelo, String motor, Integer valorPorcentualRiesgo, Marca marca) {
        this.id = id;
        this.nombreModelo = nombreModelo;
        this.motor = motor;
        this.valorPorcentualRiesgo = valorPorcentualRiesgo;
        this.marca = marca;
    }
    public ModeloDTO(Modelo modelo) {
        this.id = modelo.getId();
        this.nombreModelo = modelo.getNombreModelo();
        this.motor = modelo.getMotor();
        this.valorPorcentualRiesgo = modelo.getValorPorcentualRiesgo();
        this.marca = modelo.getMarca();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getValorPorcentualRiesgo() {
        return valorPorcentualRiesgo;
    }

    public void setValorPorcentualRiesgo(Integer valorPorcentualRiesgo) {
        this.valorPorcentualRiesgo = valorPorcentualRiesgo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ModeloDTO{" +
                "id=" + id +
                ", nombreModelo='" + nombreModelo + '\'' +
                ", motor='" + motor + '\'' +
                ", valorPorcentualRiesgo=" + valorPorcentualRiesgo +
                ", marca=" + marca +
                '}';
    }

    //tostring
    //getter setters

}
