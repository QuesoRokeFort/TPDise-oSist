package Hibernate.Dao;


import Hibernate.Model.Modelo;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ModeloDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveModelo(Modelo modelo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(modelo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateModelo(Modelo modelo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(modelo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Modelo getModeloById(int id){
        Transaction transaction = null;
        Modelo modelo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

           modelo = session.get(Modelo.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return modelo;
    }

    public static List<Modelo> getModelos(){
        Transaction transaction = null;
        List<Modelo> modelos = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            modelos = session.createQuery("from Modelo").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return modelos;
    }

    public static void deleteModelo(int id){
        Transaction transaction = null;
        Modelo modelo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            modelo = session.get(Modelo.class,id);
            session.delete(modelo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
