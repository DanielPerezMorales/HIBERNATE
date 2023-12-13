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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.*

/**
 *
 * @author Jorge Martinez
 */
@Entity
@Table(name = "profesor")

public class Profesor implements Serializable {

    // COLUMNAS DE LA TABLA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Telefono")
    private String Telefono;
    @Column(name = "Direccion")
    private String Direccion;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "sala_profesores_id")
    private sala_profesores sala;  

    // CONSTRUCTORES
    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }
    
    public Profesor(String Nombre, String Telefono, String Direccion) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }
    
    public Profesor(String Nombre, String Telefono, String Direccion, sala_profesores sala_id) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.sala = sala_id;
    }
    
    public Profesor(Integer id, String Nombre, String Telefono, String Direccion, sala_profesores sala_id) {
        this.id=id;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.sala = sala_id;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", sala_id=" + sala + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.Nombre);
        hash = 43 * hash + Objects.hashCode(this.Telefono);
        hash = 43 * hash + Objects.hashCode(this.Direccion);
        hash = 43 * hash + Objects.hashCode(this.sala);
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.sala, other.sala);
    }
    
    // RELACIONES
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
       
    private List<Asignaturas> Asignaturas;

    public List<Asignaturas> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    public sala_profesores getSala() {
        return sala;
    }

    public void setSala(sala_profesores sala) {
        this.sala = sala;
    }

    public void addAsignaturas(Asignaturas a1) {
        if (Asignaturas == null) Asignaturas=new ArrayList<>();
            Asignaturas.add(a1);
            a1.setProfesor(this);
    }
    
    
}
