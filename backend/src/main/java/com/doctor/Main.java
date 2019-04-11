package com.doctor;

import static com.doctor.WebDriverManager.close;
import static com.doctor.WebDriverManager.getDriver;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/amaiwa/Downloads/chromedriver/chromedriver");
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SearchVisitPage searchVisitPage = new SearchVisitPage();

		try {
			getDriver().manage().window().maximize();
			loginPage.performLogin();
			searchVisitPage.open();
			searchVisitPage.searchVisit("okulistyka", "2019-06-06", "2019-12-12");
			Thread.sleep(10000);
			homePage.open();
			homePage.logout();
		} catch (InterruptedException e) {
			e.printStackTrace(System.err);
		} finally {
			close();
		}
	}
}
