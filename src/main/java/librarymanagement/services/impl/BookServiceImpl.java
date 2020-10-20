/*
 *@author ThomasLe
 *@date Oct 12, 2020
*/
package librarymanagement.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;
import librarymanagement.utils.HibernateUtils;

@SessionScoped
public class BookServiceImpl implements BookService, Serializable {

	private static final long serialVersionUID = -3268025886861382138L;

	@Override
	public List<Book> getAll() {
		Transaction transaction = null;
		List<Book> books = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			books = session.createQuery("FROM Book b", Book.class).getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book get(Integer id) {
		Transaction transaction = null;
		Book book = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			book = session.get(Book.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void save(Book book) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
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
	public void remove(Book book) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.remove(book);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
