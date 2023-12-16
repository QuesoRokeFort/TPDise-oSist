package Hibernate.Model;

import DTO.CoberturaDTO;
import DTO.TipoCoberturaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cobertura")
public class Cobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idTipoCobertura")
    private TipoCobertura tipoCobertura;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;


    @Column(name = "ajusteSiniestro", length = 20)
    private String ajusteSiniestro;

    @Column(name = "ajustePorKm")
    private Integer ajustePorKm;

    @Column(name = "ajusteCantHijos")
    private Integer ajusteCantHijos;
    @Column (name = "precio")
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Cobertura() {
    }

    public Cobertura(Integer id, TipoCobertura tipoCobertura, Proveedor proveedor, String ajusteSiniestro, Integer ajustePorKm, Integer ajusteCantHijos,Integer precio) {
        this.id = id;
        this.tipoCobertura = tipoCobertura;
        this.proveedor = proveedor;
        this.ajusteSiniestro = ajusteSiniestro;
        this.ajustePorKm = ajustePorKm;
        this.ajusteCantHijos = ajusteCantHijos;
        this.precio = precio;
    }

    public Cobertura(CoberturaDTO cobertura) {
        this.id = cobertura.getId();
        this.tipoCobertura = cobertura.getTipoCobertura();
        this.proveedor = cobertura.getProveedor();
        this.ajusteSiniestro = cobertura.getAjusteSiniestro();
        this.ajustePorKm = cobertura.getAjustePorKm();
        this.ajusteCantHijos = cobertura.getAjusteCantHijos();
        this.precio = cobertura.getPrecio();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getAjusteSiniestro() {
        return ajusteSiniestro;
    }

    public void setAjusteSiniestro(String ajusteSiniestro) {
        this.ajusteSiniestro = ajusteSiniestro;
    }

    public Integer getAjustePorKm() {
        return ajustePorKm;
    }

    public void setAjustePorKm(Integer ajustePorKm) {
        this.ajustePorKm = ajustePorKm;
    }

    public Integer getAjusteCantHijos() {
        return ajusteCantHijos;
    }

    public void setAjusteCantHijos(Integer ajusteCantHijos) {
        this.ajusteCantHijos = ajusteCantHijos;
    }

    @Override
    public String toString() {
        return "Cobertura{" +
                "id=" + id +
                ", tipoCobertura=" + tipoCobertura +
                ", proveedor=" + proveedor +
                ", ajusteSiniestro='" + ajusteSiniestro + '\'' +
                ", ajustePorKm=" + ajustePorKm +
                ", ajusteCantHijos=" + ajusteCantHijos +
                '}';
    }
}