package DTO;

import Hibernate.Model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class PrecioProveedorTipoDTO{

    private Integer id;

    private Integer precio;

    private Proveedor proveedor;

    private TipoCobertura tipoCobertura;

    public PrecioProveedorTipoDTO() {

    }
    public PrecioProveedorTipoDTO(Integer id, Integer precio, Proveedor proveedor, TipoCobertura tipoCobertura) {
        this.id = id;
        this.precio = precio;
        this.proveedor = proveedor;
        this.tipoCobertura = tipoCobertura;
    }
    public PrecioProveedorTipoDTO(PrecioProveedorTipo precioProveedorTipo) {
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
        return "PrecioProveedorTipoDTO{" +
                "id=" + id +
                ", precio=" + precio +
                ", proveedor=" + proveedor +
                ", tipoCobertura=" + tipoCobertura +
                '}';
    }
}


//tostring
//getter setters


