/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import librarymanagement.entities.Category;
import librarymanagement.services.CategoryService;

@Named
@ConversationScoped
public class CategoryBean implements Serializable {

	private static final long serialVersionUID = -842664746377744660L;

	@Inject
	private CategoryService categoryService;

	private List<Category> categories;
	private Category currentCategory;

	@PostConstruct
	public void init() {
		categories = categoryService.getAll();
	}

	public void update() {
		currentCategory.setUpdatedDate(LocalDate.now());
		categoryService.update(currentCategory);
	}

	public void remove(Category category) {
		categoryService.delete(category);
		categories.remove(category);
	}

	public void showCategoryDetails() {
		currentCategory = new Category();
		currentCategory.setCreatedDate(LocalDate.now());
		categoryService.add(currentCategory);
		categories.add(currentCategory);
	}

	public void showTable() {
		currentCategory = null;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

}
