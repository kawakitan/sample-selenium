/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kawakitan.sample.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author kawakitan
 */
public class Application {

	public static void main(String[] args) {
		Application app = new Application();
		app.execute();
	}

	public Application() {

	}

	public void execute() {
		final WebDriver driver = createChromeDriver();

		driver.get("https://github.com/kawakitan");
		new WebDriverWait(driver, 30).until(ExpectedConditions.titleIs("kawakitan · GitHub"));

		// Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		// WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));

		// visibilityOfElementLocatedは要素が表示（hightまたはwidthが0より大）になるまで待つ
		// presenceOfElementLocatedはDOM要素として存在していればOKとなる

		// tag[attribute=value]
		WebElement e = driver.findElement(By.cssSelector("a[href='/kawakitan?tab=repositories']"));
		e.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.titleIs("kawakitan / Repositories · GitHub"));

		// tag.class tag#id
		WebElement e1 = driver.findElement(By.cssSelector("div.TableObject-item > input#your-repos-filter"));
		e1.sendKeys("sample");

		WebElement e2 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.issues-reset-query")));
		e2.click();

		// FileUtils.copyFile(((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.FILE), new
		// File(driver.getClass().getName() + "-xxx.png"));

		driver.quit();
	}

	private WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "./driver/mac/chromedriver");
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
