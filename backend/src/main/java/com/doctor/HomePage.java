package com.doctor;

import static com.doctor.WebDriverManager.getDriver;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

	@Override
	protected String getUrl() {
		return "https://online.enel.pl/";
	}

	private Finder logoutButton() {
		return Finder.search().byId("logoutForm").byTagName("a");
	}

	private Finder userDropdown() {
		return Finder.search().byClassName("name");
	}

	public void logout() {
		userDropdown().click();
		logoutButton().waitForElement();
		logoutButton().click();
	}
}
