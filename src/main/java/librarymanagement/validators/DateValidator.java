/*
 *@author ThomasLe
 *@date Oct 20, 2020
*/
package librarymanagement.validators;

import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value instanceof LocalDate) {
			LocalDate releasedDate = (LocalDate) value;
			LocalDate today = LocalDate.now();
			if (releasedDate.isEqual(today) || releasedDate.isAfter(today)) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Release date validation failed", "Release date must be before today"));
			}
		}
	}

}
