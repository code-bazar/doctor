package com.doctor;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentSearchStep extends SearchStep {

	@Override
	public List<WebElement> findNextList(WebDriver driver, WebElement element) {
		WebElement parentElement = findNext(driver, element);
		List<WebElement> result = new ArrayList<>();
		result.add(parentElement);
		return result;
	}

	@Override
	public WebElement findNext(WebDriver driver, WebElement element) {
		return parent(driver, element);
	}

	private static WebElement parent(WebDriver driver, WebElement element) {
		return (WebElement) ((JavascriptExecutor) driver)
			.executeScript("return arguments[0].parentNode;", element);
	}
}
