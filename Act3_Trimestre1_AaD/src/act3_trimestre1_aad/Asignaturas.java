/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act3_trimestre1_aad;

/**
 * 
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
//import javax.persistence.*


@Entity
@Table(name = "asignaturas")

public class Asignaturas implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Nombre")
    private String Nombre;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "ProfesorID")
    private Profesor profesor;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "ModulosID")
    private Módulos modulos;

    // CONSTRUCTORES
    public Asignaturas() {
    }

    public Asignaturas(String Nombre, Profesor profesor) {
        this.Nombre = Nombre;
        this.profesor = profesor;
    }

    public Asignaturas(String Nombre, Módulos modulos) {
        this.Nombre = Nombre;
        this.modulos = modulos;
    }

    public Asignaturas(String Nombre, Profesor profesor, Módulos modulos) {
        this.Nombre = Nombre;
        this.profesor = profesor;
        this.modulos = modulos;
    }
    
    public Asignaturas(Integer id, String Nombre, Profesor profesor, Módulos modulos) {
        this.id=id;
        this.Nombre = Nombre;
        this.profesor = profesor;
        this.modulos = modulos;
    }

    public Asignaturas(String Nombre) {
        this.Nombre = Nombre;
    }
    
    // METODOS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.Nombre);
        hash = 37 * hash + Objects.hashCode(this.profesor);
        hash = 37 * hash + Objects.hashCode(this.modulos);
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
        final Asignaturas other = (Asignaturas) obj;
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        return Objects.equals(this.modulos, other.modulos);
    }

    @Override
    public String toString() {
        return "Asignaturas{" + "id=" + id + ", Nombre=" + Nombre + ", Profesor_id=" + profesor + ", Modulo_id=" + modulos + '}';
    }
    
    //RELACIONES

    public Módulos getModulos() {
        return modulos;
    }

    public void setModulos(Módulos modulos) {
        this.modulos = modulos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    

}
