package com.doctor;

import static com.doctor.WebDriverManager.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Utils {

  private  Utils() {
  }

	private static final WebDriver driver = getDriver();

	public static WebDriverWait driverWait() {
		int maxSecondsTimeout = 30;
		return new WebDriverWait(driver, maxSecondsTimeout);
	}
}
