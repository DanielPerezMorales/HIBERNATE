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
public class Prueba_Aula_Alumno_OneToMany {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Alumnos.class)
                .addAnnotatedClass(Aula.class)
                .buildSessionFactory();
        Session miSesion = miFactory.openSession();
        int num = sc.nextInt();

        switch (num) {

            case 1:
                //Creamos el alumno. Iniciamos la transacción. Guardamos. Commit
                Aula c = miSesion.get(Aula.class, 1);
                Alumnos a1 = new Alumnos("Rafael", "Ortega", "2000-12-01");
                //-------------   INSERCION -------------
                //Asociamos alumno con aula. Guardamos la info en las dos tablas
                c.addAlumnos(a1);
                miSesion.beginTransaction();
                miSesion.save(a1);
                miSesion.getTransaction().commit();
                System.out.println("Registro insertado en Aula y Alumnos" + c.toString());
                break;
            case 2:
                miSesion.beginTransaction();
                Aula cli = miSesion.get(Aula.class, 1);
                if (cli != null) {
                    System.out.println(cli.toString());
                } else {
                    System.out.println("Cliente no existe");
                }
                //Obtenemos los campos relacionado
                for (Alumnos p : cli.getAlumnos_aula()) {
                    System.out.println(p.toString());
                }
                miSesion.getTransaction().commit();
                break;
            case 3:
                // borrar campos seleccionados
                miSesion.beginTransaction();
                Aula clienteBorrado = miSesion.get(Aula.class, 4);
                if (clienteBorrado != null) {
                    miSesion.delete(clienteBorrado);
                    System.out.println("Registro borrado en alumno y aula" + clienteBorrado.toString());
                } else {
                    System.out.println("El aula no existe");
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
