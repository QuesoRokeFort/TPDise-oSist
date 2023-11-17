package Hibernate.Dao;

import Hibernate.Model.Pago;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PagoDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void savePago(Pago pago){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(pago);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updatePago(Pago pago){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(pago);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Pago getPagoById(int id){
        Transaction transaction = null;
        Pago pago = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            pago = session.get(Pago.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return pago;
    }

    public static List<Pago> getPagos(){
        Transaction transaction = null;
        List<Pago> pagos = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            pagos = session.createQuery("from Pago").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return pagos;
    }

    public static void deletePago(int id){
        Transaction transaction = null;
        Pago pago = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            pago = session.get(Pago.class,id);
            session.delete(pago);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
