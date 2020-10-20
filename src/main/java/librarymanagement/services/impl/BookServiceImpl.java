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
	public List<Book> getAll() throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			List<Book> books = session.createQuery("FROM Book", Book.class).getResultList();
			return books;
		}
	}

	@Override
	public Book get(Integer id) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Book book = session.get(Book.class, id);
			return book;
		}
	}

	@Override
	public void save(Book book) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		}
	}

	@Override
	public void update(Book book) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(book);
			transaction.commit();
		}
	}

	@Override
	public void remove(Book book) throws HibernateException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.remove(book);
			transaction.commit();
		}
	}
}
