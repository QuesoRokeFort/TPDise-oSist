package Hibernate.Dao;

import Hibernate.Model.Pais;
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
    public static void saveProvincia(Provincia provincia){
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
    public static void updateProvincia(Provincia provincia){
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

    public static Provincia getProvinciaById(int id){
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

    public static List<Provincia> getProvincias(){
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

    public static void deleteProvincia(int id){
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
    public static List<Provincia> getProvinciasByPais(Pais pais) {
        Transaction transaction = null;
        List<Provincia> provincias = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String query = "from Provincia where pais = :pais";
            provincias = session.createQuery(query, Provincia.class)
                    .setParameter("pais", pais)
                    .list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception appropriately
        }
        return provincias;
    }
}
