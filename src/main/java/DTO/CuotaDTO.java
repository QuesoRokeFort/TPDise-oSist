package DTO;

import Hibernate.Model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;


public class CuotaDTO{

    private Integer id;

    private LocalDate ultimoDiaDePago;

    private Integer importe;

    private Poliza poliza;

    private Pago pago;

    public CuotaDTO() {
    }

    public CuotaDTO(Integer id, LocalDate ultimoDiaDePago, Integer importe, Poliza poliza, Pago pago) {
        this.id = id;
        this.ultimoDiaDePago = ultimoDiaDePago;
        this.importe = importe;
        this.poliza = poliza;
        this.pago = pago;
    }

    public CuotaDTO(Cuota cuota) {
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
        return "CuotaDTO{" +
                "id=" + id +
                ", ultimoDiaDePago=" + ultimoDiaDePago +
                ", importe=" + importe +
                ", poliza=" + poliza +
                ", pago=" + pago +
                '}';
    }
}



//tostring
//getter setters


