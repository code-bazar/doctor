package com.doctor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchStep {

	public WebElement findNext(WebDriver driver, WebElement element) {
		throw new UnsupportedOperationException();
	}

	public List<WebElement> findNextList(WebDriver driver, WebElement element) {
		throw new UnsupportedOperationException();
	}

	public static SearchStep byId(String id) {
		return new BySearchStep(By.id(id));
	}

	public static SearchStep byTagName(String tagName) {
		return new BySearchStep(By.tagName(tagName));
	}

	public static SearchStep byClassName(String className) {
		return new BySearchStep(By.className(className));
	}

	public static SearchStep byParent() {
		return new ParentSearchStep();
	}
}
