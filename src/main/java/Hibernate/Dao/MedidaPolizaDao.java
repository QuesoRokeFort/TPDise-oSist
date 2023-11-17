package Hibernate.Dao;


import Hibernate.Model.MedidaPoliza;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MedidaPolizaDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveMedidaPoliza(MedidaPoliza medidaPoliza){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(medidaPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateMedidaPoliza(MedidaPoliza medidaPoliza){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(medidaPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static MedidaPoliza getMedidaPolizaById(int id){
        Transaction transaction = null;
        MedidaPoliza medidaPoliza = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidaPoliza = session.get(MedidaPoliza.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return medidaPoliza;
    }

    public static List<MedidaPoliza> getMedidasPolizas(){
        Transaction transaction = null;
        List<MedidaPoliza> medidasPolizas = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidasPolizas = session.createQuery("from MedidaPoliza").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return medidasPolizas;
    }

    public static void deleteMedidaPoliza(int id){
        Transaction transaction = null;
        MedidaPoliza medidaPoliza = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidaPoliza = session.get(MedidaPoliza.class,id);
            session.delete(medidaPoliza);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
