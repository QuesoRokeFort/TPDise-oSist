package Hibernate.Model;

import DTO.ProveedorDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreProv", length = 20)
    private String nombreProv;

    public Proveedor() {
    }
    public Proveedor(Integer id, String nombreProv) {
        this.id = id;
        this.nombreProv = nombreProv;
    }
    public Proveedor(ProveedorDTO proveedor) {
        this.id = proveedor.getId();
        this.nombreProv = proveedor.getNombreProv();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombreProv='" + nombreProv + '\'' +
                '}';
    }
}