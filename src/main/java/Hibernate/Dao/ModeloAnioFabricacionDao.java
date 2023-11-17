package Hibernate.Dao;


import Hibernate.Model.ModeloAnioFabricacion;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ModeloAnioFabricacionDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveModeloAnioFabricacion(ModeloAnioFabricacion modeloAnioFabricacion){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(modeloAnioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateModeloAnioFabricacion(ModeloAnioFabricacion modeloAnioFabricacion){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(modeloAnioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static ModeloAnioFabricacion getModeloAnioFabricacionById(int id){
        Transaction transaction = null;
        ModeloAnioFabricacion modeloAnioFabricacion = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            modeloAnioFabricacion = session.get(ModeloAnioFabricacion.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return modeloAnioFabricacion;
    }

    public static List<ModeloAnioFabricacion> getModelosAniosFabricacion(){
        Transaction transaction = null;
        List<ModeloAnioFabricacion> modelosAniosFabricacion = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            modelosAniosFabricacion = session.createQuery("from ModeloAnioFabricacion").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return modelosAniosFabricacion;
    }

    public static void deleteModeloAnioFabricacion(int id){
        Transaction transaction = null;
        ModeloAnioFabricacion modeloAnioFabricacion = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            modeloAnioFabricacion = session.get(ModeloAnioFabricacion.class,id);
            session.delete(modeloAnioFabricacion);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
