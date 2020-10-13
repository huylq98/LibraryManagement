/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Transient
	private boolean editable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
