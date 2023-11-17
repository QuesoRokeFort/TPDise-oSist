package Hibernate.Dao;


import Hibernate.Model.Hijo;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HijoDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveHijo(Hijo hijo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(hijo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateHijo(Hijo hijo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(hijo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Hijo getHijoById(int id){
        Transaction transaction = null;
        Hijo hijo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            hijo = session.get(Hijo.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return hijo;
    }

    public static List<Hijo> getHijos(){
        Transaction transaction = null;
        List<Hijo> hijos = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            hijos = session.createQuery("from Hijo").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return hijos;
    }

    public static void deleteHijo(int id){
        Transaction transaction = null;
        Hijo hijo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            hijo = session.get(Hijo.class,id);
            session.delete(hijo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
