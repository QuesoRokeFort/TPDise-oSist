package Hibernate.Dao;


import Hibernate.Model.AnioFabricacion;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnioFabricacionDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveAnioFabricacion(AnioFabricacion anioFabricacion){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(anioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateAnioFabricacion(AnioFabricacion anioFabricacion){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(anioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static AnioFabricacion getAnioFabricacionById(int id){
        Transaction transaction = null;
        AnioFabricacion anioFabricacion= null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            anioFabricacion = session.get(AnioFabricacion.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return anioFabricacion;
    }

    public static List<AnioFabricacion> getAniosFabricacion(){
        Transaction transaction = null;
        List<AnioFabricacion> aniosFabricacion = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            aniosFabricacion = session.createQuery("from AnioFabricacion").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return aniosFabricacion;
    }

    public static void deleteAnioFabricacion(int id){
        Transaction transaction = null;
        AnioFabricacion anioFabricacion = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            anioFabricacion = session.get(AnioFabricacion.class,id);
            session.delete(anioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
