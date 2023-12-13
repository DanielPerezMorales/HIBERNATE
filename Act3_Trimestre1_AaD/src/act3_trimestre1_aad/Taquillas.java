/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act3_trimestre1_aad;

import act3_trimestre1_aad.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.*

/**
 *
 * @author Jorge Martinez
 */
@Entity
@Table(name = "taquillas")

public class Taquillas implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "AlumnosID")
    private Alumnos Alumno;

    // CONSTRUCTORES
    public Taquillas() {
    }

    public Taquillas(int id) {
        this.id = id;
    }

    public Taquillas(Alumnos Alumno) {
        this.Alumno = Alumno;
    }
    
    public Taquillas(Integer id, Alumnos Alumno) {
        this.id=id;
        this.Alumno = Alumno;
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
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.Alumno);
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
        final Taquillas other = (Taquillas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.Alumno, other.Alumno);
    }

    @Override
    public String toString() {
        return "Taquillas{" + "id=" + id + ", Alumno_id=" + Alumno + '}';
    }
    
    // RELACIONES
    public Alumnos getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumnos Alumno) {
        this.Alumno = Alumno;
    }
}
