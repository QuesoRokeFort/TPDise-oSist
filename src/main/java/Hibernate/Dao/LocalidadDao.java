package Hibernate.Dao;

import Hibernate.Model.Localidad;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LocalidadDao {
	// guardado
	// borrado
	// get by id
	// get all
	// update
	public static void saveLocalidad(Localidad localidad){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.save(localidad);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}
	public static void updateLocalidad(Localidad localidad){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.saveOrUpdate(localidad);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}

	public static Localidad getLocalidadById(int id){
		Transaction transaction = null;
		Localidad localidad = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			localidad = session.get(Localidad.class,id);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return localidad;
	}

	public static List<Localidad> getLocalidades(){
		Transaction transaction = null;
		List<Localidad> localidades = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			localidades = session.createQuery("from Localidad").list();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return localidades;
	}

	public static void deleteLocalodad(int id){
		Transaction transaction = null;
		Localidad localidad = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			localidad = session.get(Localidad.class,id);
			session.delete(localidad);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}

	public static List<Localidad> getLocalidadesByProvincia(int idProvincia) {
		Session session = null;
		Transaction transaction = null;
		List<Localidad> localidades = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Localidad l " +
					"WHERE l.provincia.id = :idProvincia";

			Query<Localidad> query = session.createQuery(hql, Localidad.class);
			query.setParameter("idProvincia", idProvincia);

			localidades = query.getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // Maneja la excepción según tus necesidades.
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return localidades;
	}
}

