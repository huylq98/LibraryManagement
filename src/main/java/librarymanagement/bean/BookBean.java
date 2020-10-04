/*
 *@author HuyLQ19
 *@date Oct 4, 2020
*/
package librarymanagement.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import librarymanagement.entity.Book;
import librarymanagement.service.BookService;

@Named("BookBean")
@RequestScoped
public class BookBean {
	private BookService bookService = new BookService();
//	List<Book> books = bookService.getAllBooks();

	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
}
