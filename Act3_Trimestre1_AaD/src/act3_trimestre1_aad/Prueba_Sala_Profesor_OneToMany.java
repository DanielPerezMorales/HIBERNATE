/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act3_trimestre1_aad;

import act3_trimestre1_aad.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Medac
 */
public class Prueba_Sala_Profesor_OneToMany {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(sala_profesores.class)
                .addAnnotatedClass(Profesor.class)
                .buildSessionFactory();
        Session miSesion = miFactory.openSession();
        int num = sc.nextInt();

        switch (num) {

            case 1:
                // Insert
                sala_profesores s = miSesion.get(sala_profesores.class, 1);
                Profesor p = new Profesor("Jorge","633600550","Calle Adolfo Suarez");
                s.addProfesor(p);
                miSesion.beginTransaction();
                miSesion.save(p);
                miSesion.getTransaction().commit();
                System.out.println("Registro insertado en Aula y Alumnos" + s.toString());
                break;
            case 2:
                // Select
                miSesion.beginTransaction();
                sala_profesores cli = miSesion.get(sala_profesores.class, 1);
                if (cli != null) {
                    System.out.println(cli.toString());
                } else {
                    System.out.println("sala de profesores no existe");
                }
                //Obtenemos los pedidos del cliente relacionado
                for (Profesor prof : cli.getProfesores()) {
                    System.out.println(prof.toString());
                }
                miSesion.getTransaction().commit();
                break;
            case 3:
                // Delete
                miSesion.beginTransaction();
                sala_profesores SalaBorrado = miSesion.get(sala_profesores.class, 4);
                if (SalaBorrado != null) {
                    miSesion.delete(SalaBorrado);
                    System.out.println("Registro borrado en Profesor y Asignaturas" + SalaBorrado.toString());
                } else {
                    System.out.println("La sala no existe");
                }

                miSesion.getTransaction().commit();
                break;
            default:
                System.out.println("No hay método seleccionado para esta acción");
                break;

        }
        miSesion.close();
        miFactory.close();

    }
}
