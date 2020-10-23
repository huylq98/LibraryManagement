/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;

@Named
@ConversationScoped
public class BookBean implements Serializable {

	private static final long serialVersionUID = -6310537176437206875L;

	@Inject
	private BookService bookService;

	private List<Book> books;
	private Book currentBook;

	@PostConstruct
	public void init() {
		books = bookService.getAll();
	}

	public void update() {
		currentBook.setUpdatedDate(LocalDate.now());
		bookService.update(currentBook);
	}

	public void remove(Book book) {
		bookService.delete(book);
		books.remove(book);
	}

	public void showBookDetails() {
		currentBook = new Book();
		currentBook.setCreatedDate(LocalDate.now());
		bookService.add(currentBook);
		books.add(currentBook);
	}

	public void showTable() {
		currentBook = null;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getCurrentBook() {
		return currentBook;
	}

	public void setCurrentBook(Book currentBook) {
		this.currentBook = currentBook;
	}

}
