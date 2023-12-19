package Hibernate.Dao;


import Hibernate.Model.Vehiculo;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class VehiculoDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveVehiculo(Vehiculo vehiculo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(vehiculo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateVehiculo(Vehiculo vehiculo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(vehiculo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Vehiculo getVehiculoById(int id){
        Transaction transaction = null;
        Vehiculo vehiculo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

          vehiculo = session.get(Vehiculo.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return vehiculo;
    }

    public static List<Vehiculo> getVehiculos(){
        Transaction transaction = null;
        List<Vehiculo> vehiculos = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            vehiculos = session.createQuery("from Vehiculo").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return vehiculos;
    }

    public static void deleteVehiculo(int id){
        Transaction transaction = null;
        Vehiculo vehiculo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            vehiculo = session.get(Vehiculo.class,id);
            session.delete(vehiculo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Vehiculo getVehiculoByPatente(String patente) {
        Transaction transaction = null;
        Vehiculo vehiculo = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Usar HQL para realizar la consulta por patente
            String hql = "FROM Vehiculo WHERE patente = :patente";
            Query<Vehiculo> query = session.createQuery(hql, Vehiculo.class);
            query.setParameter("patente", patente);

            vehiculo = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejar la excepción adecuadamente en un entorno de producción
        }

        return vehiculo;
    }
}
