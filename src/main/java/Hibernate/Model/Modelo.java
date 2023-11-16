package Hibernate.Model;

import DTO.DireccionDTO;
import DTO.ModeloDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Integer id;

    @Column(name = "nombreModelo", length = 20)
    private String nombreModelo;

    @Column(name = "motor", length = 20)
    private String motor;

    @Column(name = "valorPorcentualRiesgo")
    private Integer valorPorcentualRiesgo;

    @ManyToOne
    @JoinColumn(name = "Marca_id")
    private Marca marca;

    public Modelo() {
    }

    public Modelo(Integer id, String nombreModelo, String motor, Integer valorPorcentualRiesgo, Marca marca) {
        this.id = id;
        this.nombreModelo = nombreModelo;
        this.motor = motor;
        this.valorPorcentualRiesgo = valorPorcentualRiesgo;
        this.marca = marca;
    }
    public Modelo(ModeloDTO modelo) {
        this.id = modelo.getId();
        this.nombreModelo = modelo.getNombreModelo();
        this.motor = modelo.getMotor();
        this.valorPorcentualRiesgo = modelo.getValorPorcentualRiesgo();
        this.marca = modelo.getMarca();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Modelo{" +
                "id=" + id +
                ", nombreModelo='" + nombreModelo + '\'' +
                ", motor='" + motor + '\'' +
                ", valorPorcentualRiesgo=" + valorPorcentualRiesgo +
                ", marca=" + marca +
                '}';
    }
}