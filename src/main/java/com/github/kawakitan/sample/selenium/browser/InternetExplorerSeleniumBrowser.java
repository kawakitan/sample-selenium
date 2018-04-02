package com.github.kawakitan.sample.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerSeleniumBrowser extends SeleniumBrowser {
	protected WebDriver createWebDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		
		return new InternetExplorerDriver(capabilities);
	}

	protected void doInitialize() {
		 System.setProperty("webdriver.ie.driver", "./driver/win/Win32/IEDriverServer.exe");
		
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.ie.silentOutput", "true");
		System.setProperty("webdriver.ie.logFile", "nul");
	}
}
