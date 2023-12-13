/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act3_trimestre1_aad;

import act3_trimestre1_aad.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class PruebaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        try { 
            //SessionFactory instancia = (SessionFactory) HibernateUtil.buildSessionFactory();
            //Sesiones. Factory crea la sesión conforme al fichero de configuración de hibernate
            //Añadimos tantas clases como utilicemos con addAnnotatedClass
            //Session. Crea la sesión de conexión a la base de datos
            SessionFactory instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory(); 
            Session session = instancia.openSession();
            //Creamos objetos. No pasamos un id lo recupera hibernate
            Customer c = new Customer("Antonio","Lopez",500);
            //Transacciones. Insertamos/Guardamos objeto en la tabla
            session.beginTransaction();
            session.save(c);
            
            //Actualizamos un objeto con update. Tenemos que incluir id
            Customer c2 = new Customer(2,"UPDATE","UPDATE",300);
            session.update(c2);
            
            //Eliminamos el objecto c3. Elimina en base al id
            Customer c3 = new Customer("Pepe","Perez",300);
            session.save(c3); //Podemos borrar solo con el id del objeto (setID)
            session.delete(c3);
            
            session.getTransaction().commit(); //También permite rollback()
            System.out.println("Registro insertado/actualizado/borrado");
            
            //------ HQL --------
            //Consulta 1
            String hql = "FROM Customer"; 
            Query<Customer> consulta = session.createQuery(hql,Customer.class); 
            List<Customer> results = consulta.getResultList();
            for(Customer cust : results){
                System.out.println(cust);
            }
            
            //Consulta 2
            //String hql = "FROM Customer WHERE id=:id"; 
            Query<Customer> consulta2 = session.createQuery("FROM Customer WHERE id=:id",Customer.class); 
            consulta2.setParameter("id",1);
            Customer customer = consulta2.getSingleResult();
            List<Customer> results2 = consulta2.getResultList();
            System.out.println(customer);
            //try .. catch (NoResultException e)
            
            session.close();
        }catch(HibernateException he){
            System.out.println(he);
        }finally{
            
        }
       */ 
   }
}
    

