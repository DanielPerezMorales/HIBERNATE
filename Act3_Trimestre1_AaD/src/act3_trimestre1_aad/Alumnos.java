/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act3_trimestre1_aad;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.*

/**
 *
 * @author Jorge Martinez
 */
@Entity
@Table(name = "alumnos")

public class Alumnos implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String Nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "id_Aula")
    private Aula aula;
    
    // CONSTRUCTORES NECESARIOS    
    public Alumnos() {
    }
    
    public Alumnos(int id) {
        this.id=id;
    }
    
    public Alumnos(int id, String Nombre, String apellido, String fecha_nacimiento) {
        this.id=id;
        this.Nombre = Nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public Alumnos(String Nombre, String apellido, String fecha_nacimiento, Aula Aula_id) {
        this.Nombre = Nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.aula = Aula_id;
    }
    
    public Alumnos(Integer id,String Nombre, String apellido, String fecha_nacimiento, Aula Aula_id) {
        this.id=id;
        this.Nombre = Nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.aula = Aula_id;
    }

    public Alumnos(String Nombre, String apellido, String fecha_nacimiento) {
        this.Nombre = Nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    // METODOS GET Y SET
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // METODO NECESARIOS
    @Override
    public String toString() {
        return "Alumnos{" + "id=" + id + ", Nombre=" + Nombre + ", apellido=" + apellido + ", fecha_nacimiento=" + fecha_nacimiento + ", Aula_id=" + aula + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.Nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido);
        hash = 41 * hash + Objects.hashCode(this.fecha_nacimiento);
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
        final Alumnos other = (Alumnos) obj;
        if (this.aula != other.aula) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    //RELACIONES
    @OneToOne(mappedBy = "Alumno",cascade=CascadeType.ALL)
        private Taquillas Taquillas;

    public Taquillas getTaquillas() {
        return Taquillas;
    }

    public void setTaquillas(Taquillas Taquillas) {
        this.Taquillas = Taquillas;
    }
    
    
    //Este atributo va a @OneToMany
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    @OneToMany(mappedBy = "alumnos_matriculas", cascade = CascadeType.ALL)
       
    private List<Matriculas> matriculas_alumnos;

    public List<Matriculas> getMatriculas_alumnos() {
        return matriculas_alumnos;
    }

    public void setMatriculas_alumnos(List<Matriculas> matriculas_alumnos) {
        this.matriculas_alumnos = matriculas_alumnos;
    }
    
    // Relación Many To Many (Alumnos-Modulos)
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "matriculas",
            joinColumns = {
                @JoinColumn(name = "AlumnosID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ModulosID")}
    )
    
    private List<Módulos> modulo = new ArrayList<Módulos>();
    
    public List<Módulos> getModulo() {
        return modulo;
    }
    
    public void addModulo(Módulos p)
    {
        this.modulo.add(p);
        p.getAlumno().add(this);
    }
    
    public void setModulo(List<Módulos> modulo) {
        this.modulo = modulo;
    }
    
}
    
  
