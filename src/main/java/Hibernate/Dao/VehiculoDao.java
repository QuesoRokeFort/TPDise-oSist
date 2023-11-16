package Hibernate.Dao;


import Hibernate.Model.Vehiculo;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

}
