/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import librarymanagement.entities.Category;
import librarymanagement.services.CategoryService;
import librarymanagement.utils.HibernateUtils;

@SessionScoped
public class CategoryServiceImpl implements CategoryService, Serializable {

	private static final long serialVersionUID = -6179870571118614583L;

	@Override
	public List<Category> getAll() {
		Transaction transaction = null;
		List<Category> categories = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			categories = session.createQuery("FROM Category", Category.class).getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category get(Integer id) {
		Transaction transaction = null;
		Category category = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			category = session.get(Category.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void save(Category category) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(category);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Category category) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.remove(category);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
