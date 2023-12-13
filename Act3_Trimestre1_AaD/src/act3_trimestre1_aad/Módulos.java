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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "módulos")

public class Módulos implements Serializable {
    
    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;

    // CONSTRUCTORES
    public Módulos() {
    }

    public Módulos(String nombre) {
        this.nombre = nombre;
    }
    
    public Módulos(Integer id) {
        this.id = id;
    }
    
    public Módulos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // METODOS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "M\u00f3dulos{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nombre);
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
        final Módulos other = (Módulos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    // RELACIONES
    @OneToMany(mappedBy = "modulos_matriculas", cascade = CascadeType.ALL)
       
    private List<Matriculas> matriculas;

    public List<Matriculas> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matriculas> matriculas) {
        this.matriculas = matriculas;
    }
    
    @OneToMany(mappedBy = "modulos", cascade = CascadeType.ALL)
       
    private List<Asignaturas> Asignaturas;

    public List<Asignaturas> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }


    public void addAsignaturas(Asignaturas a1) {
        if (Asignaturas == null) Asignaturas=new ArrayList<>();
            Asignaturas.add(a1);
            a1.setModulos(this);
    }
    
    // Relación Many To Many (Modulos-Alumnos)
    //MAPEO
    @ManyToMany(mappedBy = "modulo")
    private List<Alumnos> alumnos = new ArrayList<Alumnos>();

    public List<Alumnos> getAlumno() {
        return alumnos;
    }

    public void setAlumno(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
    
    public void addAlumno(Alumnos c)
    {
        this.alumnos.add(c);
        c.getModulo().add(this);
    }    
        
}
