package com.doctor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BySearchStep extends SearchStep {

	private By by;

	public BySearchStep(By by) {
		this.by = by;
	}

	@Override
	public WebElement findNext(WebDriver driver, WebElement element) {
		if (element == null) {
			return driver.findElement(by);
		} else {
			return element.findElement(by);
		}
	}

	@Override
	public List<WebElement> findNextList(WebDriver driver, WebElement element) {
		if (element == null) {
			return driver.findElements(by);
		} else {
			return element.findElements(by);
		}
	}
}
