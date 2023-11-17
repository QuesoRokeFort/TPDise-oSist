package Hibernate.Dao;


import Hibernate.Model.CambioPoliza;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CambioPolizaDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveCambioPoliza(CambioPoliza cambioPoliza){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(cambioPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateCambioPoliza(CambioPoliza cambioPoliza){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(cambioPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static CambioPoliza getCambioPolizaById(int id){
        Transaction transaction = null;
        CambioPoliza cambioPoliza = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cambioPoliza = session.get(CambioPoliza.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return cambioPoliza;
    }

    public static List<CambioPoliza> getCambiosPoliza(){
        Transaction transaction = null;
        List<CambioPoliza> cambiosPoliza = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cambiosPoliza = session.createQuery("from CambioPoliza").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return cambiosPoliza;
    }

    public static void deleteCambioPoliza(int id){
        Transaction transaction = null;
        CambioPoliza cambioPoliza = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cambioPoliza = session.get(CambioPoliza.class,id);
            session.delete(cambioPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
