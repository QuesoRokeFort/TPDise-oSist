package Hibernate.Model;

import DTO.ProvinciaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "nombre", length = 20)
    private String nombre;

    @Column (name = "cpostal")
    private int codPostal;
    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais pais;
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true) // no seria mapped by= idProvincia?
    private List<Localidad> localidades  = new ArrayList<>();

    public Provincia(ProvinciaDTO provincia) {
        this.id = provincia.getId();
        this.nombre = provincia.getNombre();
        this.codPostal = provincia.getCodPostal();
        this.pais = new Pais(provincia.getPais());
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codPostal=" + codPostal +
                ", pais=" + pais +
                '}';
    }

    public Provincia(int id, String nombre, int codPostal, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.codPostal = codPostal;
        this.pais = pais;
    }

    public Provincia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
