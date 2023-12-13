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
public class Prueba_Modulos_Asignaturas_OneToMany {

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
                Módulos c = miSesion.get(Módulos.class, 1);
                Profesor p=miSesion.get(Profesor.class, 2);
                Asignaturas a1 = new Asignaturas("Biologia",p);
                c.addAsignaturas(a1);
                miSesion.beginTransaction();
                miSesion.save(a1);
                miSesion.getTransaction().commit();
                System.out.println("Registro insertado en Asignaturas y Modulos" + c.toString());
                break;
            case 2:
                // Select
                miSesion.beginTransaction();
                Módulos cli = miSesion.get(Módulos.class, 1);
                if (cli != null) {
                    System.out.println(cli.toString());
                } else {
                    System.out.println("Módulos no existe");
                }
                //Obtenemos los pedidos del cliente relacionado
                for (Asignaturas p1 : cli.getAsignaturas()) {
                    System.out.println(p1.toString());
                }
                miSesion.getTransaction().commit();
                break;
            case 3:
                // Delete
                miSesion.beginTransaction();
                Módulos MódulosBorrado = miSesion.get(Módulos.class, 4);
                if (MódulosBorrado != null) {
                    miSesion.delete(MódulosBorrado);
                    System.out.println("Registro borrado en Módulos y Asignaturas" + MódulosBorrado.toString());
                } else {
                    System.out.println("El Módulos no existe");
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
