package DTO;

import Hibernate.Model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;


public class HijoDTO{

    private Integer id;

    private Date fechaDeNacimiento;

    private Sexo sexoHijo;

    private EstadoCivil estadoCivil;

    public HijoDTO() {
    }

    public HijoDTO(Integer id, Date fechaDeNacimiento, Sexo sexoHijo, EstadoCivil estadoCivil) {
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexoHijo = sexoHijo;
        this.estadoCivil = estadoCivil;
    }
    public HijoDTO(Hijo hijo) {
        this.id = hijo.getId();
        this.fechaDeNacimiento = hijo.getFechaDeNacimiento();
        this.sexoHijo = hijo.getSexoHijo();
        this.estadoCivil = hijo.getEstadoCivil();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Sexo getSexoHijo() {
        return sexoHijo;
    }

    public void setSexoHijo(Sexo sexoHijo) {
        this.sexoHijo = sexoHijo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "HijoDTO{" +
                "id=" + id +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", sexoHijo='" + sexoHijo + '\'' +
                ", estadoCivil=" + estadoCivil +
                '}';
    }
}


//tostring
//getter setters


