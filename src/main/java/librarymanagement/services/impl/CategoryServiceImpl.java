/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import librarymanagement.entities.Category;
import librarymanagement.services.CategoryService;
//import librarymanagement.utils.HibernateUtils;

@SessionScoped
public class CategoryServiceImpl implements CategoryService, Serializable {

	private static final long serialVersionUID = -6179870571118614583L;

	@PersistenceContext(unitName = "librarymangement-driver")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	@Override
	public List<Category> getAll() {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			List<Category> categories = session.createQuery("FROM Category", Category.class).getResultList();
//			return categories;
//		}
		List<Category> categories = entityManager.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
		return categories;
	}

	@Override
	public Category get(Integer id) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Category category = session.get(Category.class, id);
//			return category;
//		}
		Category category = entityManager.find(Category.class, id);
		return category;
	}

	@Override
	public void add(Category category) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.save(category);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.persist(category);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.saveOrUpdate(category);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.merge(category);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Category category) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.remove(category);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.remove(category);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}
}
