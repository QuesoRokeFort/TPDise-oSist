package Hibernate.Dao;


import DTO.ModeloDTO;
import Hibernate.Model.ModeloAnioFabricacion;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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

    public static List<ModeloAnioFabricacion> getAñoByModelo(ModeloDTO modeloDTO) {
        Transaction transaction = null;
        List<ModeloAnioFabricacion> modelosAniosFabricacion = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            modelosAniosFabricacion = session.createQuery("from ModeloAnioFabricacion where modelo.id = :modeloId", ModeloAnioFabricacion.class)
                    .setParameter("modeloId", modeloDTO.getId())
                    .list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // Log the exception or handle it in a more appropriate way
            e.printStackTrace();
            throw new RuntimeException("Error retrieving ModelosAniosFabricacion for ModeloDTO", e);
        }
        return modelosAniosFabricacion;
    }


}
