package Hibernate.Model;

import DTO.PrecioProveedorTipoDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PrecioProveedorTipo")
public class PrecioProveedorTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "precio")
    private Integer precio;  // asumo que lo agarra desde TipoCobertura

    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idTipoCobertura", referencedColumnName = "idTipoCobertura")
    private TipoCobertura tipoCobertura;

    public PrecioProveedorTipo() {
    }

    public PrecioProveedorTipo(Integer id, Integer precio, Proveedor proveedor, TipoCobertura tipoCobertura) {
        this.id = id;
        this.precio = precio;
        this.proveedor = proveedor;
        this.tipoCobertura = tipoCobertura;
    }

    public PrecioProveedorTipo(PrecioProveedorTipoDTO precioProveedorTipo) {
        this.id = precioProveedorTipo.getId();
        this.precio = precioProveedorTipo.getPrecio();
        this.proveedor = precioProveedorTipo.getProveedor();
        this.tipoCobertura = precioProveedorTipo.getTipoCobertura();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    @Override
    public String toString() {
        return "PrecioProveedorTipo{" +
                "id=" + id +
                ", precio=" + precio +
                ", proveedor=" + proveedor +
                ", tipoCobertura=" + tipoCobertura +
                '}';
    }
}