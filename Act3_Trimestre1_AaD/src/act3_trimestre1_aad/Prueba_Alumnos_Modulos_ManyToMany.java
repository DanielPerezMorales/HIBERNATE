/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act3_trimestre1_aad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Prueba_Alumnos_Modulos_ManyToMany {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Alumnos.class)
                .addAnnotatedClass(Módulos.class)
                .buildSessionFactory();
        Session miSesion = miFactory.openSession();
                
        try {  
            int num = sc.nextInt();
            switch (num) {

                case 1:
                    //Crear alumno y módulo asociado
                    Aula au = new Aula(1);
                    Alumnos a = new Alumnos("alu-a", "a", "11/11/11", au);

                    Módulos mod = new Módulos("mod-a");

                    //Asociamos Alumno y Módulo
                    a.addModulo(mod);
                    //mod.addAlumno(a);

                    //Guardamos Alumno y Módulo
                    miSesion.beginTransaction();
                    miSesion.save(a);
                    miSesion.save(mod);
                    miSesion.getTransaction().commit();

                    System.out.println("Registro insertado en tabla Matriculas, con valores de:"
                            + "\n   - Alumnos: " + au.toString()
                            + "\n   - Módulos: " + mod.toString());
                    break;
                case 2:

                            //Consulta de Alumnos
                            miSesion.beginTransaction();
                            System.out.println("-------------------- CONSULTA DE ALUMNOS --------------------.");
                            System.out.println("Se va a consultar el Alumno con id=1.");
                            Alumnos al = miSesion.get(Alumnos.class, 1);
                            if (al!=null)
                                System.out.println(al.toString());
                            else 
                                System.out.println("Alumno no existe");

                            //Obtenemos el modulo relacionado con el alumno seleccionado
                            System.out.println("Ahora se va a mostrar el modulo relacionada con el alumno anterior.");
                            for (Módulos modu:al.getModulo())
                                 System.out.println(modu.toString());
                            miSesion.getTransaction().commit();
                    break;
                case 3:
                    //--------   BORRADO CLIENTE CON PEDIDOS ASOCIADOS -------------------
                      miSesion.beginTransaction();
                      Alumnos alumnoBorrado = miSesion.get(Alumnos.class, 8);
                      if (alumnoBorrado != null) {
                          miSesion.delete(alumnoBorrado);
                          System.out.println("Registro borrado en Alumnos y Modulos" + alumnoBorrado.toString());
                      } else
                          System.out.println("El alumno no existe");
                    break;
                default:
                    System.out.println("No hay método seleccionado para esta acción");
                    break;
            }         
                miSesion.getTransaction().commit();
                miSesion.close();         
        }
        catch(Exception e) {
            e.printStackTrace();			
        }
        finally {	
            miFactory.close();
        }
    }
}
