/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act3_trimestre1_aad;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jorge Martínez IMPORTANTE. Para probar correctamente en los metodos
 * get comprobar que son ids de las tablas
 */
public class Prueba_Alumnos_Taquillas_OneToOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Alumnos.class)
                .addAnnotatedClass(Taquillas.class)
                .addAnnotatedClass(Aula.class)
                .buildSessionFactory();
        Session miSesion = miFactory.openSession();

        int num = sc.nextInt();

        switch (num) {

            case 1:
                //Creamos el alumno. Iniciamos la transacción. Guardamos. Commit
                Aula aula = miSesion.get(Aula.class, 1);
                Alumnos a1 = new Alumnos("Ana", "Perez", "21-03-2000", aula);
                Taquillas t1 = new Taquillas(a1);
                //-------------   INSERCION -------------
                //Asociamos alumno con taquilla. Guardamos la info en las dos tablas
                t1.setAlumno(a1);
                a1.setTaquillas(t1);

                miSesion.beginTransaction();
                miSesion.save(a1);
                miSesion.getTransaction().commit();

                System.out.println("Registro insertado en Taquillas y Alumno" + a1.toString());
                break;
            case 2:
                miSesion.beginTransaction();
                Taquillas t = miSesion.get(Taquillas.class, 1);
                System.out.println(t.toString());
                //Obtenemos la información del alumno relacionado
                System.out.println(t.getAlumno().toString());
                miSesion.getTransaction().commit();
                //AQUI HAY QUE CREAR ALGO PARA SEPARARLO
                miSesion.beginTransaction();
                Alumnos AlumnosConsulta = miSesion.get(Alumnos.class, 1);
                System.out.println(AlumnosConsulta.toString());
                //Obtenemos la información de la taquilla relacionada
                System.out.println(AlumnosConsulta.getTaquillas().toString());
                miSesion.getTransaction().commit();
                break;
            case 3:
                miSesion.beginTransaction();
                Alumnos AlumnosBorrado = miSesion.get(Alumnos.class, 1);
                if (AlumnosBorrado != null) {
                    miSesion.delete(AlumnosBorrado);
                    System.out.println("Registro borrado en Alumnos y Taquillas" + AlumnosBorrado.toString());
                } else {
                    System.out.println("El Alumnos no existe");
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
