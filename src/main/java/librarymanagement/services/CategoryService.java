/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.services;

import java.util.List;

import librarymanagement.entities.Category;

public interface CategoryService {
	List<Category> getAll();

	Category get(Integer id);

	void add(Category category);

	void update(Category category);

	void delete(Category category);
}
