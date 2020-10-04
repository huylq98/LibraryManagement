/*
 *@author HuyLQ19
 *@date Oct 4, 2020
*/
package librarymanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import librarymanagement.entity.Book;
import librarymanagement.utils.HibernateUtils;

public class BookService {
	public List<Book> getAllBooks() {
		Transaction transaction = null;
		List<Book> books = null;
		
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			books = session.createQuery("FROM Book", Book.class).getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		
		return books;
	}
}
