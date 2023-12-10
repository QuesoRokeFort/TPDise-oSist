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

		if (nombre != null || apellido != null || tipoDocumento != null || nroDocumento != null || idCliente != null) {
			queryString.append(" AND (");

			if (nombre != null) {
				queryString.append("p.nombrePersona = :nombre OR ");
			}
			if (apellido != null) {
				queryString.append("p.apellido = :apellido OR ");
			}
			if (tipoDocumento != null) {
				queryString.append("p.idTipoDocumento = :tipoDocumento OR ");
			}
			if (nroDocumento != null) {
				queryString.append("p.nroDocumento = :nroDocumento OR ");
			}
			if (idCliente != null) {
				queryString.append("p.cliente.nroCliente = :idCliente OR ");
			}

			// Remove the last " OR " from the query
			queryString.setLength(queryString.length() - 4);
			queryString.append(")");
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
		System.out.println(queryString);

		return query.getResultList();
	}
}


