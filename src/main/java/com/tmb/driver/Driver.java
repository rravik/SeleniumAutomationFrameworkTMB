package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	// private static WebDriver driver;
	public static void initDriver() throws Exception {

		// if(driver==null)
		if (Objects.isNull(DriverManagement.getDriver())) {
			// System.setProperty("webdriver.chrome.driver",
			// FrameworkConstants.getChromedriverpath());
			WebDriverManager.chromedriver().setup();

			DriverManagement.setDriver(new ChromeDriver());
			DriverManagement.getDriver().get(ReadPropertyFile.get("url"));
		}

	}

	public static void quitDriver() {

		// if(driver!=null)
		if (Objects.nonNull(DriverManagement.getDriver())) {
			DriverManagement.getDriver().quit();
			DriverManagement.unload();
		}
	}
}
