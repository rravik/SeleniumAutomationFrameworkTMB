package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManagement;

public final class LoginPageTests extends BaseTest{

private LoginPageTests() {
	
}


	@Test
	public void Test1() {

		DriverManagement.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);



	}
	
	@Test
	public void Test2() {

		DriverManagement.getDriver().findElement(By.name("q")).sendKeys("Automation Engineer", Keys.ENTER);


		

		
		
		
	}




}
