package Hibernate.Dao;


import Hibernate.Model.MedidaSeguridad;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MedidaSeguridadDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveMedidaSeguridad(MedidaSeguridad medidaSeguridad){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(medidaSeguridad);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateMedidaSeguridad(MedidaSeguridad medidaSeguridad){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(medidaSeguridad);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static MedidaSeguridad getMedidaSeguridadById(int id){
        Transaction transaction = null;
        MedidaSeguridad medidaSeguridad = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidaSeguridad = session.get(MedidaSeguridad.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return medidaSeguridad;
    }

    public static List<MedidaSeguridad> getMedidasSeguridad(){
        Transaction transaction = null;
        List<MedidaSeguridad> medidasSeguridad = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidasSeguridad = session.createQuery("from MedidaSeguridad").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return medidasSeguridad;
    }

    public static void deleteMedidaSeguridad(int id){
        Transaction transaction = null;
        MedidaSeguridad medidaSeguridad = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            medidaSeguridad = session.get(MedidaSeguridad.class,id);
            session.delete(medidaSeguridad);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
