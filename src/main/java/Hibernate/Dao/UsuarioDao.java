package Hibernate.Dao;

import Hibernate.Model.Pais;
import Hibernate.Model.Usuario;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UsuarioDao {

	public static void saveUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(usuario);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // O utiliza un logger para registrar la excepción
		}
	}


	public static void updateUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(usuario);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static Usuario getUsuarioById(int id) {
		Transaction transaction = null;
		Usuario usuario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			usuario = session.get(Usuario.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}

	public static List<Usuario> getUsuarios() {
		Transaction transaction = null;
		List<Usuario> usuarios = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			usuarios = session.createQuery("from Usuario").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuarios;
	}

	public static void deleteUsuario(int id) {
		Transaction transaction = null;
		Usuario usuario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			usuario = session.get(Usuario.class, id);
			session.delete(usuario);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static Usuario getUsuarioByMail(String mail) {
		Transaction transaction = null;
		Usuario usuario = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			// HQL (Hibernate Query Language) para realizar la consulta por correo electrónico
			String hql = "FROM Usuario WHERE mail = :mail";
			Query<Usuario> query = session.createQuery(hql, Usuario.class);
			query.setParameter("mail", mail);

			usuario = query.uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return (usuario != null) ? usuario : null;
	}
}
