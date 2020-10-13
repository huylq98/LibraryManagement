/*
 *@author ThomasLe
 *@date Oct 12, 2020
*/
package librarymanagement.services.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;
import librarymanagement.utils.HibernateUtils;

@RequestScoped
public class BookServiceImpl implements BookService {

	@Override
	public List<Book> getAll() {
		Transaction transaction = null;
		List<Book> books = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			books = session.createQuery("FROM Book", Book.class).getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(book);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}
}
