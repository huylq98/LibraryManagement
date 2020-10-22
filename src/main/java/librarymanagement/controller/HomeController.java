/*
 *@author ThomasLe
 *@date Oct 15, 2020
*/
package librarymanagement.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import librarymanagement.utils.Constant;

@Named
@ConversationScoped
public class HomeController implements Serializable {

	private static final long serialVersionUID = 5486642976222234552L;

	@Inject
	private Conversation conversation;

	private Integer menuNavigation;

	public void showHomeMenu() {
		menuNavigation = null;
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}

	public void showBookManagement() {
		menuNavigation = Constant.SHOW_BOOK_MANAGEMENT;
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public void showCategoryManagement() {
		menuNavigation = Constant.SHOW_CATEGORY_MANGEMENT;
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public Integer getMenuNavigation() {
		return menuNavigation;
	}

	public void setMenuNavigation(Integer menuNavigation) {
		this.menuNavigation = menuNavigation;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}
