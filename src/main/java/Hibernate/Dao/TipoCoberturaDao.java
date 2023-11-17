package Hibernate.Dao;


import Hibernate.Model.TipoCobertura;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TipoCoberturaDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveTipoCobertura(TipoCobertura tipoCobertura){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(tipoCobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateTipoCobertura(TipoCobertura tipoCobertura){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(tipoCobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static TipoCobertura getTipoCoberturaById(int id){
        Transaction transaction = null;
        TipoCobertura tipoCobertura = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

           tipoCobertura = session.get(TipoCobertura.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return tipoCobertura;
    }

    public static List<TipoCobertura> getTiposCobertura(){
        Transaction transaction = null;
        List<TipoCobertura> tiposCobertura = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            tiposCobertura = session.createQuery("from TipoCobertura").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return tiposCobertura;
    }

    public static void deleteTipoCobertura(int id){
        Transaction transaction = null;
        TipoCobertura tipoCobertura = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            tipoCobertura = session.get(TipoCobertura.class,id);
            session.delete(tipoCobertura);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
