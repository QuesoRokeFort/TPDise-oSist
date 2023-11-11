package Hibernate.Dao;

import Hibernate.Model.Provincia;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProvinciaDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public void saveProvincia(Provincia provincia){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(provincia);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public void updateProvincia(Provincia provincia){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(provincia);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public Provincia getProvinciaById(Long id){
        Transaction transaction = null;
        Provincia provincia = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            provincia = session.get(Provincia.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return provincia;
    }

    public List<Provincia> getProvincias(){
        Transaction transaction = null;
        List<Provincia> provincias = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            provincias = session.createQuery("from Provincia").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return provincias;
    }

    public void deleteProvincia(Long id){
        Transaction transaction = null;
        Provincia provincia = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            provincia = session.get(Provincia.class,id);
            session.delete(provincia);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
