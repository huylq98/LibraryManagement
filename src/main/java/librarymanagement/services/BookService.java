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

	void add(Book book);

	void update(Book book);

	void delete(Integer id);
}
