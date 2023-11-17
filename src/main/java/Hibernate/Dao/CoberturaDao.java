package Hibernate.Dao;


import Hibernate.Model.Cobertura;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CoberturaDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveCobertura(Cobertura cobertura){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(cobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateCobertura(Cobertura cobertura){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(cobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Cobertura getCoberturaById(int id){
        Transaction transaction = null;
        Cobertura cobertura = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cobertura = session.get(Cobertura.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return cobertura;
    }

    public static List<Cobertura> getCoberturas(){
        Transaction transaction = null;
        List<Cobertura> coberturas = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            coberturas = session.createQuery("from Cobertura").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return coberturas;
    }

    public static void deleteCobertura(int id){
        Transaction transaction = null;
        Cobertura cobertura = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

           cobertura = session.get(Cobertura.class,id);
            session.delete(cobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
