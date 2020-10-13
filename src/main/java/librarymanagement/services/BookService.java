/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.services;

import java.util.List;

import librarymanagement.entities.Book;

public interface BookService {
	List<Book> getAll();

	Book get(Integer id);

	void save(Book book);

	void update(Book book);

	void remove(Book book);
}
