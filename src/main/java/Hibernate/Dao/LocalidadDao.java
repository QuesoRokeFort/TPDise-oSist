package Hibernate.Dao;

import Hibernate.Model.Localidad;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}

