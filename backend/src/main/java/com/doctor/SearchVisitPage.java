package com.doctor;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchVisitPage extends Page {

	@Override
	protected String getUrl() {
		return "https://online.enel.pl/Visit/New";
	}

	public Finder city() {
		return Finder.search().byId("City");
	}

	public Finder speciality() {
		return Finder.search().byId("ListOfSpecialities");
	}
	public Finder dateFrom() {
		return Finder.search().byId("VisitDateFrom");
	}

	public Finder dateTo() {
		return Finder.search().byId("VisitDateTo");
	}

	public Finder termsCheckbox() {
		return Finder.search().byId("AcptRul");
	}

	private Finder searchButton() {
		return Finder.search().byId("sbtn");
	}

	private Finder searchResults() {
		return Finder.search().byId("Results").byClassName("box-visit");
	}

	private void setSepciality(String label) {
		speciality().setValue(label);
		speciality().byParent().click();
		termsCheckbox().waitForElement();
	}

	public void searchVisit(String speciality, String dateFrom, String dateTo) {

		city().setValue("Warszawa");
		setSepciality(speciality);
		searchButton().click();

		dateFrom().setValue(dateFrom);
		dateTo().setValue(dateTo);
		city().setValue("Warszawa");
		setSepciality(speciality);
		termsCheckbox().click();
		searchButton().click();

		searchResults().waitForElement();

		List<WebElement> availableVisits = searchResults().getElements();

		List<String> dates = availableVisits.stream()
			.map(box -> box.findElement(By.className("row-search")).findElement(By.tagName("p")))
			.map(WebElement::getText)
			.collect(Collectors.toList());

		List<String> hours = availableVisits.stream()
			.map(box -> box.findElement(By.className("row-search")).findElements(By.tagName("p")).get(1))
			.map(WebElement::getText)
			.collect(Collectors.toList());

		dates.stream()
			.forEach(System.out::println); // NOSONAR false positive
		hours.stream()
			.forEach(System.out::println); // NOSONAR false positive
	}
}
