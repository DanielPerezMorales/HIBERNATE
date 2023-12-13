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
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.*

/**
 *
 * @author Jorge Martinez
 */
@Entity
@Table(name = "sala_profesores")

public class sala_profesores implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; 

    // CONSTRUCTORES
    public sala_profesores() {
    }

    public sala_profesores(Integer id) {
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
    public String toString() {
        return "sala_profesores{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final sala_profesores other = (sala_profesores) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    // RELACIONES
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
       
    private List<Profesor> profesores;

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void addProfesor(Profesor p) {
        if (profesores == null) profesores=new ArrayList<>();
            profesores.add(p);
            p.setSala(this);
    }
    
    
}
