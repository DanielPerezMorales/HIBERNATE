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
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "matriculas")

public class Matriculas implements Serializable {
    
    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlumnosID")
    private Integer alumnos_id;
    
    @Column(name = "ModulosID")
    private Integer módulos_id;

    // CONSTRUCTORES
    public Matriculas() {
    }

    public Matriculas(Integer alumnos_id) {
        this.alumnos_id = alumnos_id;
    }
    
    public Matriculas(Integer alumnos_id, Integer módulos_id) {
        this.alumnos_id = alumnos_id;
        this.módulos_id = módulos_id;
    }

    // METODOS
    public Integer getAlumnos_id() {
        return alumnos_id;
    }

    public void setAlumnos_id(Integer alumnos_id) {
        this.alumnos_id = alumnos_id;
    }

    public Integer getMódulos_id() {
        return módulos_id;
    }

    public void setMódulos_id(Integer módulos_id) {
        this.módulos_id = módulos_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.alumnos_id);
        hash = 71 * hash + Objects.hashCode(this.módulos_id);
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
        final Matriculas other = (Matriculas) obj;
        if (!Objects.equals(this.alumnos_id, other.alumnos_id)) {
            return false;
        }
        return Objects.equals(this.módulos_id, other.módulos_id);
    }

    @Override
    public String toString() {
        return "Matriculas{" + "alumnos_id=" + alumnos_id + ", m\u00f3dulos_id=" + módulos_id + '}';
    }
    
    // RELACIONES
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "alumnos_id")
    private Alumnos alumnos_matriculas; //Este atributo va a @OneToMany en Cliente

    public Alumnos getAlumnos_matriculas() {
        return alumnos_matriculas;
    }

    public void setAlumnos_matriculas(Alumnos alumnos_matriculas) {
        this.alumnos_matriculas = alumnos_matriculas;
    }
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "módulos_id")
    private Módulos modulos_matriculas; //Este atributo va a @OneToMany en Cliente

    public Módulos getModulos_matriculas() {
        return modulos_matriculas;
    }

    public void setModulos_matriculas(Módulos modulos_matriculas) {
        this.modulos_matriculas = modulos_matriculas;
    }
    
    
    
}
