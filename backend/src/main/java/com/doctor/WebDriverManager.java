package com.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class WebDriverManager {

  private WebDriverManager() {
  }

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}

		return driver;
	}

	public static void close() {
		if (driver != null) {
			driver.close();
		}
	}


}
