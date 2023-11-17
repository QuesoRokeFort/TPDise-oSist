package DTO;

import Hibernate.Model.Pago;
import Hibernate.Model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class PagoDTO {
    private int id;
    private Integer nroRecibo;

    private Date fechaPago;

    private Date horaPago;  // asumimos que seria Date

    private Integer importeFinal;

    private String metodoDePago;

    private Integer recargosMora;

    private Integer bonificacion;

    private Usuario usuario;

    public PagoDTO() {
    }

    public PagoDTO(int id, Integer nroRecibo, Date fechaPago, Date horaPago, Integer importeFinal, String metodoDePago, Integer recargosMora, Integer bonificacion, Usuario usuario) {
        this.id = id;
        this.nroRecibo = nroRecibo;
        this.fechaPago = fechaPago;
        this.horaPago = horaPago;
        this.importeFinal = importeFinal;
        this.metodoDePago = metodoDePago;
        this.recargosMora = recargosMora;
        this.bonificacion = bonificacion;
        this.usuario = usuario;
    }

    public PagoDTO(Pago pago) {
        this.id = pago.getId();
        this.nroRecibo = pago.getNroRecibo();
        this.fechaPago = pago.getFechaPago();
        this.horaPago = pago.getHoraPago();
        this.importeFinal = pago.getImporteFinal();
        this.metodoDePago = pago.getMetodoDePago();
        this.recargosMora = pago.getRecargosMora();
        this.bonificacion = pago.getBonificacion();
        this.usuario = pago.getUsuario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(Date horaPago) {
        this.horaPago = horaPago;
    }

    public Integer getImporteFinal() {
        return importeFinal;
    }

    public void setImporteFinal(Integer importeFinal) {
        this.importeFinal = importeFinal;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public Integer getRecargosMora() {
        return recargosMora;
    }

    public void setRecargosMora(Integer recargosMora) {
        this.recargosMora = recargosMora;
    }

    public Integer getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Integer bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "PagoDTO{" +
                "id=" + id +
                ", nroRecibo=" + nroRecibo +
                ", fechaPago=" + fechaPago +
                ", horaPago=" + horaPago +
                ", importeFinal=" + importeFinal +
                ", metodoDePago='" + metodoDePago + '\'' +
                ", recargosMora=" + recargosMora +
                ", bonificacion=" + bonificacion +
                ", usuario=" + usuario +
                '}';
    }
}
