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
	public List<Category> getAll() throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			List<Category> categories = session.createQuery("FROM Category", Category.class).getResultList();
			return categories;
		}
	}

	@Override
	public Category get(Integer id) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Category category = session.get(Category.class, id);
			return category;
		}
	}

	@Override
	public void save(Category category) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
		}
	}

	@Override
	public void update(Category category) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(category);
			transaction.commit();
		}
	}

	@Override
	public void remove(Category category) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.remove(category);
			transaction.commit();
		}
	}
}
