package Hibernate.Model;


import DTO.DireccionDTO;
import DTO.VehiculoDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "chasis", length = 20)
    private String chasis;

    @Column(name = "patente", length = 20)
    private String patente;

    @Column(name = "kilometrosAnuales")
    private Integer kilometrosAnuales;
    @Column(name = "motor", length = 20)
    private String motor;


    @ManyToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "anio")
    private AnioFabricacion anioFabricacion;

    public Vehiculo() {
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Vehiculo(VehiculoDTO vehiculo) {
        this.id = vehiculo.getId();
        this.chasis = vehiculo.getChasis();
        this.patente = vehiculo.getPatente();
        this.kilometrosAnuales = vehiculo.getKilometrosAnuales();
        this.motor = vehiculo.getMotor();
        this.modelo = new Modelo(vehiculo.getModelo());
        this.anioFabricacion = new AnioFabricacion(vehiculo.getAnioFabricacion());
    }

    public Vehiculo(Integer id, String chasis, String patente, Integer kilometrosAnuales, String motor, Modelo modelo, AnioFabricacion anioFabricacion) {
        this.id = id;
        this.chasis = chasis;
        this.patente = patente;
        this.kilometrosAnuales = kilometrosAnuales;
        this.motor = motor;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getKilometrosAnuales() {
        return kilometrosAnuales;
    }

    public void setKilometrosAnuales(Integer kilometrosAnuales) {
        this.kilometrosAnuales = kilometrosAnuales;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public AnioFabricacion getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(AnioFabricacion anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", chasis='" + chasis + '\'' +
                ", patente='" + patente + '\'' +
                ", kilometrosAnuales=" + kilometrosAnuales +
                ", modelo=" + modelo +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }
}
