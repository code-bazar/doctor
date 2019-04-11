package com.doctor;

public class LoginPage extends Page {

	private Finder login() {
		return Finder.search().byId("Login");
	}

	private Finder password() {
		return Finder.search().byId("Password");
	}

	private Finder termsOfUseCheckbox() {
		return Finder.search().byId("IsAcceptedRule");
	}

	private Finder loginButton() {
		return Finder.search().byClassName("js-trigger-to-submit");
	}

	private Finder notificationPopup() {
		return Finder.search().byId("NotificationPopup");
	}

	private Finder popupCloseIcon() {
		return notificationPopup().byClassName("js-close-popover");
	}


	@Override
	protected String getUrl() {
		return "https://online.enel.pl/Account/Login";
	}

	public void performLogin() {
		this.open();

    login().get().sendKeys("login");
    password().get().sendKeys("password");
		termsOfUseCheckbox().click();
		loginButton().click();

		notificationPopup().waitForElement();
		popupCloseIcon().click();
	}
}
