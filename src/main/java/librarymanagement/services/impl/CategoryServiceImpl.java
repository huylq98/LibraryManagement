/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ConversationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import librarymanagement.entities.Category;
import librarymanagement.services.CategoryService;

@ConversationScoped
public class CategoryServiceImpl implements CategoryService, Serializable {

	private static final long serialVersionUID = -6179870571118614583L;

	@PersistenceContext(unitName = "librarymangement-persistence")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	@Override
	public List<Category> getAll() {
		List<Category> categories = entityManager.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
		return categories;
	}

	@Override
	public Category get(Integer id) {
		Category category = entityManager.find(Category.class, id);
		return category;
	}

	@Override
	public void add(Category category) throws Exception {
		userTransaction.begin();
		entityManager.persist(category);
		userTransaction.commit();
	}

	@Override
	public void update(Category category) throws Exception {
		userTransaction.begin();
		entityManager.merge(category);
		userTransaction.commit();
	}

	@Override
	public void delete(Category category) throws Exception {
		userTransaction.begin();
		Category c = entityManager.find(Category.class, category.getId());
		entityManager.remove(c);
		userTransaction.commit();
	}
}
