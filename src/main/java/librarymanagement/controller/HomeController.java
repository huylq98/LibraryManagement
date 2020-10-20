/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import librarymanagement.utils.Constant;

@Named
@SessionScoped
public class HomeController implements Serializable {

	private static final long serialVersionUID = 5486642976222234552L;
	
	private Integer menuNavigation;

	public void showHomeMenu() {
		menuNavigation = null;
	}

	public void showBookManagement() {
		menuNavigation = Constant.SHOW_BOOK_MANAGEMENT;
	}

	public void showCategoryManagement() {
		menuNavigation = Constant.SHOW_CATEGORY_MANGEMENT;
	}

	public Integer getMenuNavigation() {
		return menuNavigation;
	}

	public void setMenuNavigation(Integer menuNavigation) {
		this.menuNavigation = menuNavigation;
	}

}
