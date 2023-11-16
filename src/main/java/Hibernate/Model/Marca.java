package Hibernate.Model;

import DTO.DireccionDTO;
import DTO.MarcaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Marca")
public class Marca{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreMarca", length = 20)
    private String nombreMarca;

    public Marca() {
    }

    public Marca(Integer id, String nombreMarca) {
        this.id = id;
        this.nombreMarca = nombreMarca;
    }

    public Marca(MarcaDTO marca){
        this.id = marca.getId();
        this.nombreMarca = marca.getNombreMarca();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombreMarca='" + nombreMarca + '\'' +
                '}';
    }
}