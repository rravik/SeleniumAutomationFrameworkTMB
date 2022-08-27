package com.tmb.tests;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManagement;

public class HomePageTests extends BaseTest {

	private HomePageTests() {

	}

	// VALIDATE WHEATHER TITLE IS CONTAINING Google Search
	// validate whether the is not null and the length of the title is greater than
	// 15 and less than 100
	// check for the links in the pages --> Testing Mini Bytes
	// number of links displayed is exactly 11 or 15

	@Test
	public void Test3() {

		DriverManagement.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
		String title = DriverManagement.getDriver().getTitle();
		System.out.println(title);

		Assertions.assertThat(title).as("Objects is actually null").isNotNull().as("It does not contain expected that")
				.containsIgnoringCase("Google search").hasSizeBetween(15, 100);

		/*
		 * Assert.assertTrue(Objects.nonNull(title));
		 * Assert.assertTrue(title.toLowerCase().contains("google search"));
		 * Assert.assertTrue(title.length() > 15); Assert.assertTrue(title.length() <
		 * 100);
		 */

		List<WebElement> elements = DriverManagement.getDriver().findElements(By.xpath("//h3"));
		Assertions.assertThat(elements).hasSize(12).extracting(e->e.getText()).contains("Testing Mini Bytes - YouTube");

		
	}

}
