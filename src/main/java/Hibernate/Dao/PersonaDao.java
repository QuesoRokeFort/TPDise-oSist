package Hibernate.Dao;
import DTO.PersonaDTO;
import Hibernate.Model.Persona;
import Hibernate.Model.TipoDocumento;
import Hibernate.Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public static List<Persona> getPersonaByCriteria(String nombre, String apellido, TipoDocumento tipoDocumento, int documento, int nroCliente) {
		Transaction transaction = null;
		List<Persona> personas = new ArrayList<>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Persona> criteriaQuery = builder.createQuery(Persona.class);
			Root<Persona> root = criteriaQuery.from(Persona.class);

			Predicate[] predicates = new Predicate[5];

			if (nombre != null && !nombre.isEmpty()) {
				predicates[0] = builder.equal(root.get("nombrePersona"), nombre);
			}

			if (apellido != null && !apellido.isEmpty()) {
				predicates[1] = builder.equal(root.get("apellido"), apellido);
			}

			if (tipoDocumento != null) {
				predicates[2] = builder.equal(root.get("idTipoDocumento"), tipoDocumento);
			}

			if (documento > 0) {
				predicates[3] = builder.equal(root.get("nroDocumento"), documento);
			}

			if (nroCliente > 0) {
				predicates[4] = builder.equal(root.get("idCliente"), nroCliente);
			}

			// Combina las condiciones con AND
			criteriaQuery.where(builder.and(predicates));

			List<Persona> personasConCriterios = session.createQuery(criteriaQuery).getResultList();


			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return personas;
	}

}