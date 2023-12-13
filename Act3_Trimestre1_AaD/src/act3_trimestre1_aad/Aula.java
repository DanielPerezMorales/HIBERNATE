/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act3_trimestre1_aad;

/**
 *
 * @author Medac
 */

import act3_trimestre1_aad.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.*

@Entity
@Table(name = "aula")

public class Aula implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // CONSTRUCTORES
    public Aula() {
    }

    public Aula(int id) {
        this.id = id;
    }

    // METODOS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aula other = (Aula) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + '}';
    }
    
    // RELACIONES
    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
       
    private List<Alumnos> alumnos_aula;

    public List<Alumnos> getAlumnos_aula() {
        return alumnos_aula;
    }

    public void setAlumnos_aula(List<Alumnos> alumnos_aula) {
        this.alumnos_aula = alumnos_aula;
    }
    
    public void addAlumnos(Alumnos p){
            if (alumnos_aula == null) alumnos_aula=new ArrayList<>();
            alumnos_aula.add(p);
            p.setAula(this);
        }
}
