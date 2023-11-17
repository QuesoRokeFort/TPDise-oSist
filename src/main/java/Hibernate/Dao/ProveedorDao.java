package Hibernate.Dao;


import Hibernate.Model.*;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProveedorDao{
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void saveProveedor(Proveedor proveedor){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(proveedor);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public static void updateProveedor(Proveedor proveedor){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(proveedor);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static Proveedor getProveedorById(int id){
        Transaction transaction = null;
        Proveedor proveedor = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            proveedor = session.get(Proveedor.class,id);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return proveedor;
    }

    public static List<Proveedor> getProveedores(){
        Transaction transaction = null;
        List<Proveedor> proveedores = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            proveedores = session.createQuery("from Proveedor").list();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return proveedores;
    }

    public static void deleteProveedor(int id){
        Transaction transaction = null;
        Proveedor proveedor = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            proveedor = session.get(Proveedor.class,id);
            session.delete(proveedor);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
