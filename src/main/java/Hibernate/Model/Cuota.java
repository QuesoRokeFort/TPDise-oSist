package Hibernate.Model;

import DTO.CuotaDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Cuota")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ultimoDiaDePago")
    private LocalDate ultimoDiaDePago;
    @Column(name = "importe")
    private Integer importe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPoliza")
    private Poliza poliza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPago")
    private Pago pago;


    public Cuota() {
    }

    public Cuota(Integer id, LocalDate ultimoDiaDePago, Integer importe, Poliza poliza, Pago pago) {
        this.id = id;
        this.ultimoDiaDePago = ultimoDiaDePago;
        this.importe = importe;
        this.poliza = poliza;
        this.pago = pago;
    }

    public Cuota(CuotaDTO cuota) {
        this.id = cuota.getId();
        this.ultimoDiaDePago = cuota.getUltimoDiaDePago();
        this.importe = cuota.getImporte();
        this.poliza = cuota.getPoliza();
        this.pago = cuota.getPago();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getUltimoDiaDePago() {
        return ultimoDiaDePago;
    }

    public void setUltimoDiaDePago(LocalDate ultimoDiaDePago) {
        this.ultimoDiaDePago = ultimoDiaDePago;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "id=" + id +
                ", ultimoDiaDePago=" + ultimoDiaDePago +
                ", importe=" + importe +
                ", poliza=" + poliza +
                ", pago=" + pago +
                '}';
    }
}