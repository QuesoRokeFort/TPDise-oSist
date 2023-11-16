package Hibernate.Dao;

import Hibernate.Model.Pais;
import Hibernate.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaisDao {
	// guardado
	// borrado
	// get by id
	// get all
	// update
	public static void savePais(Pais pais){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.save(pais);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}
	public static void updatePais(Pais pais){
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.saveOrUpdate(pais);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}

	public static Pais getPaisById(int id){
		Transaction transaction = null;
		Pais pais = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			pais = session.get(Pais.class,id);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return pais;
	}

	public static List<Pais> getPaises(){
		Transaction transaction = null;
		List<Pais> paises = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			paises = session.createQuery("from Pais").list();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return paises;
	}

	public static void deletePais(int id){
		Transaction transaction = null;
		Pais pais = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			pais = session.get(Pais.class,id);
			session.delete(pais);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
	}
}
