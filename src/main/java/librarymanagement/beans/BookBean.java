/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;

@Named
@SessionScoped
public class BookBean implements Serializable {

	private static final long serialVersionUID = -6310537176437206875L;

	@Inject
	private BookService bookService;
	private List<Book> books;
	private Book book;
	private boolean hidden;

	@PostConstruct
	public void init() {
		books = bookService.getAll();
	}

	public void edit() {
		hidden = true;
	}

	public void update() {
		book.setUpdatedDate(new Date());
		bookService.update(book);
		hidden = false;
	}

	public void remove(Book book) {
		bookService.remove(book);
		books.remove(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
