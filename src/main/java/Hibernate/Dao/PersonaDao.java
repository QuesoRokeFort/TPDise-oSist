package Hibernate.Dao;
import DTO.PersonaDTO;
import Hibernate.Model.Persona;
import Hibernate.Model.TipoDocumento;
import Hibernate.Util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaDao {

	public static void savePersona(Persona persona) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(persona);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void updatePersona(Persona persona) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(persona);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static Persona getPersonaById(int id) {
		Transaction transaction = null;
		Persona persona = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			persona = session.get(Persona.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return persona;
	}

	public static List<Persona> getAllPersonas() {
		Transaction transaction = null;
		List<Persona> personas = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			personas = session.createQuery("from Persona").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return personas;
	}

	public static void deletePersona(int id) {
		Transaction transaction = null;
		Persona persona = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			persona = session.get(Persona.class, id);
			session.delete(persona);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static List<Persona> getPersonaByCriteria(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento, Integer idCliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Your existing code goes here
		// Use session to access the Hibernate Session

		// Create a dynamic HQL query
		StringBuilder queryString = new StringBuilder("FROM Persona p WHERE 1=1");

		if (nombre != null) {
			queryString.append(" AND p.nombrePersona = :nombre");
		}
		if (apellido != null) {
			queryString.append(" AND p.apellido = :apellido");
		}
		if (tipoDocumento != null) {
			queryString.append(" AND p.idTipoDocumento = :tipoDocumento");
		}
		if (nroDocumento != null) {
			queryString.append(" AND p.nroDocumento = :nroDocumento");
		}
		if (idCliente != null) {
			queryString.append(" AND p.cliente.nroCliente = :idCliente");
		}

		Query<Persona> query = session.createQuery(queryString.toString(), Persona.class);

		if (nombre != null) {
			query.setParameter("nombre", nombre);
		}
		if (apellido != null) {
			query.setParameter("apellido", apellido);
		}
		if (tipoDocumento != null) {
			query.setParameter("tipoDocumento", tipoDocumento);
		}
		if (nroDocumento != null) {
			query.setParameter("nroDocumento", nroDocumento);
		}
		if (idCliente != null) {
			query.setParameter("idCliente", idCliente);
		}
		System.out.println(query);

		return query.getResultList();
	}
}


