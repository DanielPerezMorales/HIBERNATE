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
public class Prueba_Profesor_Asignatura_OneToMany {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Módulos.class)
                .addAnnotatedClass(Asignaturas.class)
                .addAnnotatedClass(Profesor.class)
                .buildSessionFactory();
        Session miSesion = miFactory.openSession();
        int num = sc.nextInt();

        switch (num) {

            case 1:
                // Insertar
                Profesor p = miSesion.get(Profesor.class, 1);
                Módulos m = miSesion.get(Módulos.class, 1);
                Asignaturas a1 = new Asignaturas("Quimica", m);
                p.addAsignaturas(a1);
                miSesion.beginTransaction();
                miSesion.save(a1);
                miSesion.getTransaction().commit();
                System.out.println("Registro insertado en Aula y Alumnos" + p.toString());
                break;
            case 2:
                // Select
                miSesion.beginTransaction();
                Profesor cli = miSesion.get(Profesor.class, 1);
                if (cli != null) {
                    System.out.println(cli.toString());
                } else {
                    System.out.println("Cliente no existe");
                }
                //Obtenemos los pedidos del cliente relacionado
                for (Asignaturas asig : cli.getAsignaturas()) {
                    System.out.println(asig.toString());
                }
                miSesion.getTransaction().commit();
                break;
            case 3:
                // Borrar
                miSesion.beginTransaction();
                Profesor ProfesorBorrado = miSesion.get(Profesor.class, 4);
                if (ProfesorBorrado != null) {
                    miSesion.delete(ProfesorBorrado);
                    System.out.println("Registro borrado en Profesor y Asignaturas" + ProfesorBorrado.toString());
                } else {
                    System.out.println("El Profesor no existe");
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
