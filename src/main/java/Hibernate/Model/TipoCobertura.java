package Hibernate.Model;

import DTO.TipoCoberturaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TipoCobertura")
public class TipoCobertura{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreTipo", length = 30)
    private String nombreTipo;

    public TipoCobertura() {
    }

    public TipoCobertura(Integer id, String nombreTipo) {
        this.id = id;
        this.nombreTipo = nombreTipo;
    }

    public TipoCobertura(TipoCoberturaDTO tipoCobertura) {
        this.id = tipoCobertura.getId();
        this.nombreTipo = tipoCobertura.getNombreTipo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return "TipoCobertura{" +
                "id=" + id +
                ", nombreTipo='" + nombreTipo + '\'' +
                '}';
    }
}