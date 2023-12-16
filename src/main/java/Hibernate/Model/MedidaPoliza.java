package Hibernate.Model;

import DTO.MedidaPolizaDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MedidaPoliza")
public class MedidaPoliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany
    @JoinColumn(name = "idMedida")
    private List<MedidaSeguridad> medidaSeguridad;

    @OneToOne
    @JoinColumn(name = "idPoliza")
    private Poliza poliza;

    public MedidaPoliza() {
    }

    public MedidaPoliza(Integer id, List<MedidaSeguridad> medidaSeguridad, Poliza poliza) {
        this.id = id;
        this.medidaSeguridad = medidaSeguridad;
        this.poliza = poliza;
    }
    public MedidaPoliza(MedidaPolizaDTO medidaPoliza) {
        this.id = medidaPoliza.getId();
        medidaPoliza.getMedidaSeguridad().forEach(m-> this.medidaSeguridad.add(new MedidaSeguridad(m)));
        this.poliza = medidaPoliza.getPoliza();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MedidaSeguridad> getMedidaSeguridad() {
        return medidaSeguridad;
    }

    public void setMedidaSeguridad(List<MedidaSeguridad> medidaSeguridad) {
        this.medidaSeguridad = medidaSeguridad;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    @Override
    public String toString() {
        return "MedidaPoliza{" +
                "id=" + id +
                ", medidaSeguridad=" + medidaSeguridad +
                ", poliza=" + poliza +
                '}';
    }
}