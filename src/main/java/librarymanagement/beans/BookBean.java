/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import librarymanagement.entities.Book;
import librarymanagement.services.BookService;
import librarymanagement.services.CategoryService;

@Named
@SessionScoped
public class BookBean implements Serializable {

	private static final long serialVersionUID = -6310537176437206875L;

	@Inject
	private BookService bookService;

	@Inject
	private CategoryService categoryService;

	private List<Book> books;
	private Book currentBook;
	private Integer categoryID;

	@PostConstruct
	public void init() {
		books = bookService.getAll();
	}

	public void update() {
		currentBook.setUpdatedDate(LocalDate.now());
		if (categoryID != null) {
			currentBook.setCategory(categoryService.get(categoryID));
		}
		bookService.update(currentBook);
		categoryID = null;
	}

	public void remove(Book book) {
		bookService.remove(book);
		books.remove(book);
	}

	public void showBookDetails() {
		currentBook = new Book();
		currentBook.setCreatedDate(LocalDate.now());
		bookService.save(currentBook);
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

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
}
