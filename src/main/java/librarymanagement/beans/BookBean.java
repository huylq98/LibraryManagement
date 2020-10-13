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

	private boolean hidden;

	@PostConstruct
	public void init() {
		books = bookService.getAll();
	}

	public void edit(Book book) {
		books.forEach(b -> b.setEditable(false));
		book.setEditable(true);
		hidden = true;
	}

	public void update(Book book) {
		book.setUpdatedDate(new Date());
		bookService.update(book);
		books.forEach(b -> b.setEditable(false));
		hidden = false;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
