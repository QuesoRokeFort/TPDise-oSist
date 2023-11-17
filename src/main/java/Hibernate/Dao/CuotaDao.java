package Hibernate.Dao;


import Hibernate.Model.Cuota;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CuotaDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveCuota(Cuota cuota){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(cuota);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateCuota(Cuota cuota){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(cuota);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Cuota getCuotaById(int id){
        Transaction transaction = null;
        Cuota cuota = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cuota = session.get(Cuota.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return cuota;
    }

    public static List<Cuota> getCuotas(){
        Transaction transaction = null;
        List<Cuota> cuotas = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cuotas = session.createQuery("from Cuota").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return cuotas;
    }

    public static void deleteCuota(int id){
        Transaction transaction = null;
        Cuota cuota = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            cuota = session.get(Cuota.class,id);
            session.delete(cuota);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
