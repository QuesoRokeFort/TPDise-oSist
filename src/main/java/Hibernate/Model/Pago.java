package Hibernate.Model;

import DTO.PagoDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nroRecibo")
    private Integer nroRecibo;

    @Column(name = "fechaPago")
    private Date fechaPago;

    @Column(name = "horaPago")
    private Date horaPago;  // asumimos que seria Date

    @Column(name = "importeFinal")
    private Integer importeFinal;

    @Column(name = "metodoDePago")  // es el unico que pusimos como string en vez de varchar 20 o 10
    private String metodoDePago;

    @Column(name = "recargosMora")
    private Integer recargosMora;

    @Column(name = "bonificacion")
    private Integer bonificacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Pago() {
    }

    public Pago(Integer id, Integer nroRecibo, Date fechaPago, Date horaPago, Integer importeFinal, String metodoDePago, Integer recargosMora, Integer bonificacion, Usuario usuario) {
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

    public Pago(PagoDTO pago) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Pago{" +
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