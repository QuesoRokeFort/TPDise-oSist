package Hibernate.Model;

import DTO.HijoDTO;
import DTO.PolizaDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Hijo")
public class Hijo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexoHijo")
    private Sexo sexoHijo;

    @Enumerated(EnumType.STRING)
    @Column(name = "idEstadoCivil")
    private EstadoCivil estadoCivil;
    @ManyToOne
    @JoinColumn(name = "poliza_id") // Use the actual column name
    private Poliza poliza;
    @ManyToOne
    @JoinColumn(name = "cambioPoliza_id")
    private CambioPoliza cambioPoliza;

    public Hijo() {
    }

    public Hijo(Integer id, Date fechaDeNacimiento, Sexo sexoHijo, EstadoCivil estadoCivil) {
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

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
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