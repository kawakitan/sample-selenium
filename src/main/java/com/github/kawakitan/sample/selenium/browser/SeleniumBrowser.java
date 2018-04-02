package com.github.kawakitan.sample.selenium.browser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SeleniumBrowser implements Browser {

	private static final Pattern PTN_BY = Pattern
			.compile("^(name|id|class|link|tag|css|xpath):(.+)$");

	private WebDriver driver;

	public SeleniumBrowser() {
	}

	public static By by(final String name) {
		By by = null;
		if (null != name && 0 < name.length()) {
			final Matcher m = PTN_BY.matcher(name);
			if (m.find()) {
				String type = m.group(1);
				String value = m.group(2);
				if ("name".equals(type)) {
					by = By.name(value);
				} else if ("id".equals(type)) {
					by = By.id(value);
				} else if ("class".equals(type)) {
					by = By.className(value);
				} else if ("link".equals(type)) {
					by = By.linkText(value);
				} else if ("tag".equals(type)) {
					by = By.tagName(value);
				} else if ("css".equals(type)) {
					by = By.cssSelector(value);
				} else if ("xpath".equals(type)) {
					by = By.xpath(value);
				}
			} else {
				by = By.name(name);
			}
		}
		return by;
	}

	@Override
	public void initialize() {
		doInitialize();
	}

	@Override
	public void destory() {
		driver.quit();
	}

	@Override
	public void open(final String url) {
		if (null == driver) {
			driver = createWebDriver();
		}

		driver.get(url);
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public String getValue(final String name) {

		final By by = by(name);

		final List<WebElement> elements = driver.findElements(by);

		String value = null;

		if (null != elements && 0 < elements.size()) {
			final WebElement firstElement = getFirstElement(elements);

			final String tag = firstElement.getTagName().toLowerCase();
			if ("input".equals(tag.toLowerCase())) {
				final String type = firstElement.getAttribute("type")
						.toLowerCase();
				if ("text".equals(type)) {
					value = firstElement.getAttribute("value");
				} else if ("password".equals(type)) {
					value = firstElement.getAttribute("value");
				} else if ("radio".equals(type)) {
					for (WebElement element : elements) {

					}
				} else {
				}
			} else {

			}
		}

		return value;
	}

	@Override
	public void setValue(final String name, final String value) {

	}

	protected abstract WebDriver createWebDriver();

	protected abstract void doInitialize();

	private WebElement getFirstElement(final List<WebElement> elements) {
		WebElement element = null;
		if (null != elements && 0 < elements.size()) {
			element = elements.get(0);
		}
		return element;
	}

}
