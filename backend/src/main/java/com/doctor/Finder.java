package com.doctor;

import static com.doctor.Utils.driverWait;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Finder {

	private static final WebDriver driver = WebDriverManager.getDriver();

	private List<SearchStep> steps;

	private Finder() {
		this(new ArrayList<>());
	}

	private Finder(List<SearchStep> steps) {
		this.steps = new ArrayList<>(steps);
	}

	public static Finder search() {
		return new Finder();
	}

	private Finder addSearchStep(SearchStep step) {
		Finder result = new Finder(this.steps);
		result.steps.add(step);
		return result;
	}

	public Finder byClassName(String className) {
		return addSearchStep(SearchStep.byClassName(className));
	}

	public Finder byId(String id) {
		return addSearchStep(SearchStep.byId(id));
	}

	public Finder byTagName(String tagName) {
		return addSearchStep(SearchStep.byTagName(tagName));
	}

	public Finder byParent() {
		return addSearchStep(SearchStep.byParent());
	}

	public WebElement get() {
		return get(driver);
	}

	public WebElement get(WebDriver driver) {
		List<WebElement> elementList = getElements(driver);
		return elementList.isEmpty() ? null : elementList.get(0);
	}

	public List<WebElement> getElements() {
		return getElements(driver);
	}

	public List<WebElement> getElements(WebDriver driver) {
		if (steps.isEmpty()) {
			return new ArrayList<>();
		}
		WebElement current = null;
		for (int i = 0; i < steps.size() - 1; i++) {
			SearchStep step = steps.get(i);
			current = step.findNext(driver, current);
		}
		SearchStep lastStep = steps.get(steps.size() - 1);
		return lastStep.findNextList(driver, current);
	}

	public void click() {
		try {
			new Actions(driver).moveToElement(this.get()).click().perform();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

	private void selectOptionByLabel(String label) {
		this.byParent().waitForElement();
		this.byParent().click();
		Select select = select(this.get());
		select.selectByValue(getValueByLabel(label));
		this.byParent().click();
	}

	private String getValueByLabel(String label) {
		Finder options = this.byTagName("option");
		options.waitForElements();
		List<WebElement> optionElements = options.getElements();
		for (WebElement option: optionElements) {
			if (option.getText().contains(label)) {
				return  option.getAttribute("value");
			}
		}
		throw new IllegalStateException();
	}

	public void setValue(String value) {
		if ("select".equalsIgnoreCase(this.get().getTagName())) {
			selectOptionByLabel(value);
		} else {
			this.setAttribute("value", value);
		}
	}

	public void waitForElement() {
		driverWait()
			.until(webDriver -> this.get(webDriver) != null && this.get(webDriver).isDisplayed());
	}

	public void waitForElements() {
		driverWait()
			.until(webDriver -> this.getElements(webDriver).size() > 3);
	}

	private void setAttribute(String attributeName, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
			this.get(), attributeName, value);
	}

	private static Select select(WebElement element) {
		return new Select(element);
	}
}
