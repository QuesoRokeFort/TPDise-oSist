package Hibernate.Model;

import DTO.HijoDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Hijo")
public class Hijo {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Column(name = "sexoHijo", length = 10)
    private String sexoHijo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstadoCivil")
    private EstadoCivil estadoCivil;

    public Hijo() {
    }

    public Hijo(Integer id, Date fechaDeNacimiento, String sexoHijo, EstadoCivil estadoCivil) {
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexoHijo = sexoHijo;
        this.estadoCivil = estadoCivil;
    }
    public Hijo(HijoDTO hijo) {
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

    public String getSexoHijo() {
        return sexoHijo;
    }

    public void setSexoHijo(String sexoHijo) {
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
        return "Hijo{" +
                "id=" + id +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", sexoHijo='" + sexoHijo + '\'' +
                ", estadoCivil=" + estadoCivil +
                '}';
    }
    // Otros campos y métodos getters/setters
}