package Hibernate.Model;

import DTO.CambioPolizaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CambioPoliza")
public class CambioPoliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patente", length = 20)
    private String patente;

    @Column(name = "motor", length = 20)
    private String motor;

    @Column(name = "chasis", length = 20)
    private String chasis;

    @Column(name = "kmAño") // la columna esta con ñ, el atributo con ni
    private Integer kmAnio;

    @Column(name = "siniestrosAño")  // la columna esta con ñ, el atributo con ni
    private Integer siniestrosAnio;

    @ManyToOne
    @JoinColumn(name = "idTipoCobertura")
    private TipoCobertura tipoCobertura;

    public CambioPoliza() {
    }

    public CambioPoliza(Integer id, String patente, String motor, String chasis, Integer kmAnio, Integer siniestrosAnio, TipoCobertura tipoCobertura) {
        this.id = id;
        this.patente = patente;
        this.motor = motor;
        this.chasis = chasis;
        this.kmAnio = kmAnio;
        this.siniestrosAnio = siniestrosAnio;
        this.tipoCobertura = tipoCobertura;
    }

    public CambioPoliza(CambioPolizaDTO cambioPoliza) {
        this.id = cambioPoliza.getId();
        this.patente = cambioPoliza.getPatente();
        this.motor = cambioPoliza.getMotor();
        this.chasis = cambioPoliza.getChasis();
        this.kmAnio = cambioPoliza.getKmAnio();
        this.siniestrosAnio = cambioPoliza.getSiniestrosAnio();
        this.tipoCobertura = cambioPoliza.getTipoCobertura();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public Integer getKmAnio() {
        return kmAnio;
    }

    public void setKmAnio(Integer kmAnio) {
        this.kmAnio = kmAnio;
    }

    public Integer getSiniestrosAnio() {
        return siniestrosAnio;
    }

    public void setSiniestrosAnio(Integer siniestrosAnio) {
        this.siniestrosAnio = siniestrosAnio;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    @Override
    public String toString() {
        return "CambioPoliza{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", motor='" + motor + '\'' +
                ", chasis='" + chasis + '\'' +
                ", kmAnio=" + kmAnio +
                ", siniestrosAnio=" + siniestrosAnio +
                ", tipoCobertura=" + tipoCobertura +
                '}';
    }
}