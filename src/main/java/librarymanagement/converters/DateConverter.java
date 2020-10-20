/*
 *@author ThomasLe
 *@date Oct 19, 2020
*/
package librarymanagement.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LocalDate releasedDate = null;
		List<DateTimeFormatter> dateTimeFormaters = Arrays.asList(DateTimeFormatter.ofPattern("ddMMyyyy"),
				DateTimeFormatter.ofPattern("dd-MM-yyyy"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		for (DateTimeFormatter dtf : dateTimeFormaters) {
			try {
				releasedDate = LocalDate.parse(value, dtf);
			} catch (DateTimeParseException e) {
			}
		}
		if (releasedDate == null) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error converting release date",
					"Invalid date format"));
		}

		return releasedDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDate releasedDate;
		if (value instanceof LocalDate) {
			releasedDate = (LocalDate) value;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return releasedDate.format(dtf);
		}
		return "";
	}

}
