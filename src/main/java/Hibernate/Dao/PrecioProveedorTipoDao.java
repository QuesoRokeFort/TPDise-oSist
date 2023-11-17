package Hibernate.Dao;


import Hibernate.Model.*;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PrecioProveedorTipoDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void savePrecioProveedorTipo(PrecioProveedorTipo precioProveedorTipo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(precioProveedorTipo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updatePrecioProveedorTipo(PrecioProveedorTipo precioProveedorTipo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(precioProveedorTipo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static PrecioProveedorTipo getPrecioProveedorTipoById(int id){
        Transaction transaction = null;
        PrecioProveedorTipo precioProveedorTipo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            precioProveedorTipo = session.get(PrecioProveedorTipo.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return precioProveedorTipo;
    }

    public static List<PrecioProveedorTipo> getPreciosProveedoresTipos(){
        Transaction transaction = null;
        List<PrecioProveedorTipo> preciosProveedoresTipos = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            preciosProveedoresTipos = session.createQuery("from PrecioProveedorTipo").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return preciosProveedoresTipos;
    }

    public static void deletePrecioProveedorTipo(int id){
        Transaction transaction = null;
        PrecioProveedorTipo precioProveedorTipo = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            precioProveedorTipo = session.get(PrecioProveedorTipo.class,id);
            session.delete(precioProveedorTipo);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
