/*
 *@author ThomasLe
 *@date Oct 12, 2020
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

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;
//import librarymanagement.utils.HibernateUtils;

@SessionScoped
public class BookServiceImpl implements BookService, Serializable {

	private static final long serialVersionUID = -3268025886861382138L;

	@PersistenceContext(unitName = "librarymangement-driver")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	@Override
	public List<Book> getAll() {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			List<Book> books = session.createQuery("FROM Book", Book.class).getResultList();
//			return books;
//		}
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		return books;
	}

	@Override
	public Book get(Integer id) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Book book = session.get(Book.class, id);
//			return book;
//		}
		Book book = entityManager.find(Book.class, id);
		return book;
	}

	@Override
	public void add(Book book) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.save(book);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.persist(book);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Book book) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.saveOrUpdate(book);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.merge(book);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Book book) {
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			Transaction transaction = session.beginTransaction();
//			session.remove(book);
//			transaction.commit();
//		}
		try {
			userTransaction.begin();
			entityManager.remove(book);
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}
}
