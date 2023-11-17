package Hibernate.Dao;


import Hibernate.Model.Poliza;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PolizaDao {
    // guardado
    // borrado
    // get by id
    // get all
    // update
    public static void savePoliza(Poliza poliza) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(poliza);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static void updatePoliza(Poliza poliza) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(poliza);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static Poliza getPolizaById(int id) {
        Transaction transaction = null;
        Poliza poliza = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            poliza = session.get(Poliza.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return poliza;
    }

    public static List<Poliza> getPolizas() {
        Transaction transaction = null;
        List<Poliza> polizas = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            polizas = session.createQuery("from Poliza").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return polizas;
    }

    public static void deletePoliza(int id) {
        Transaction transaction = null;
        Poliza poliza = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            poliza = session.get(Poliza.class, id);
            session.delete(poliza);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
