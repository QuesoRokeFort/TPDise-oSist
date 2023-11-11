package Hibernate.Model;

import jakarta.persistence.*;
@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "nombre")
    private String nombre;

    @Column (name = "cpostal")
    private int codPostal;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

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
