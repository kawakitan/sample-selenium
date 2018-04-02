package com.github.kawakitan.sample.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSeleniumBrowser extends SeleniumBrowser {

	protected WebDriver createWebDriver() {
		return new ChromeDriver();
	}

	protected void doInitialize() {
		System.setProperty("webdriver.chrome.driver",
				"./driver/win/chromedriver.exe");
	}

}
