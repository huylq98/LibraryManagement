/*
 *@author ThomasLe
 *@date Oct 12, 2020
*/
package librarymanagement.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ConversationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;

@ConversationScoped
public class BookServiceImpl implements BookService, Serializable {

	private static final long serialVersionUID = -3268025886861382138L;

	@PersistenceContext(unitName = "librarymangement-persistence")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	@Override
	public List<Book> getAll() {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		return books;
	}

	@Override
	public Book get(Integer id) {
		Book book = entityManager.find(Book.class, id);
		return book;
	}

	@Override
	public void add(Book book) throws Exception {
		userTransaction.begin();
		entityManager.persist(book);
		userTransaction.commit();
	}

	@Override
	public void update(Book book) throws Exception {
		userTransaction.begin();
		entityManager.merge(book);
		userTransaction.commit();
	}

	@Override
	public void delete(Book book) throws Exception {
		userTransaction.begin();
		Book b = entityManager.find(Book.class, book.getId());
		entityManager.remove(b);
		userTransaction.commit();

	}
}
