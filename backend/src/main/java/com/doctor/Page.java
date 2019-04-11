package com.doctor;

import static com.doctor.WebDriverManager.getDriver;

import org.openqa.selenium.*;

public abstract class Page {
	protected WebDriver driver = getDriver();

	public void open() {
		driver.navigate().to(getUrl());
	}

	protected abstract String getUrl();
}
