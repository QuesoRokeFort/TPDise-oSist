package Hibernate.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HijoPoliza")
public class HijoPoliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idHijo")
    private Hijo hijo;

    @ManyToOne
    @JoinColumn(name = "idPoliza")
    private Poliza poliza;

    
}