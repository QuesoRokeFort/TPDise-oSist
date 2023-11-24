package Hibernate.Dao;
import Hibernate.Model.Direccion;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class DireccionDao {
	public static void saveDireccion(Direccion direccion) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(direccion);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public static void updateDireccion(Direccion direccion) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(direccion);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public static Direccion getDireccionById(int id) {
		Transaction transaction = null;
		Direccion direccion = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			direccion = session.get(Direccion.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return direccion;
	}

	public static List<Direccion> getDirecciones() {
		Transaction transaction = null;
		List<Direccion> direcciones = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			direcciones = session.createQuery("from Direccion").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return direcciones;
	}

	public static void deleteDireccion(int id) {
		Transaction transaction = null;
		Direccion direccion = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			direccion = session.get(Direccion.class, id);
			session.delete(direccion);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
