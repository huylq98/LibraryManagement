/*
 *@author ThomasLe
 *@date Oct 20, 2020
*/
package librarymanagement.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.hibernate.HibernateException;

import librarymanagement.entities.Category;
import librarymanagement.services.CategoryService;
import librarymanagement.services.impl.CategoryServiceImpl;

@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		Category category = null;
		try {
			category = categoryService.get(Integer.parseInt(value));
			FacesContext.getCurrentInstance().addMessage("mainForm:bookCategory",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Category name", category.getName()));
		} catch (HibernateException | NumberFormatException | NullPointerException e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error converting release date",
					"Invalid categoryID"));
		}
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Category) {
			Category category = (Category) value;
			return String.valueOf(category.getId());
		}
		return "";
	}
}
