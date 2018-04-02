package com.github.kawakitan.sample.selenium.browser;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class SeleniumBrowserTest {

	@Test
	public void testByUnmatch() {
		By by = null;
		
		String name = null;
		by = SeleniumBrowser.by(name);
		assertNull(by);
		
		name = "";
		by = SeleniumBrowser.by(name);
		assertNull(by);

		name = "name";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: name", by.toString());

		name = "id";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: id", by.toString());

		name = "class";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: class", by.toString());

		name = "link";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: link", by.toString());

		name = "tag";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: tag", by.toString());

		name = "css";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: css", by.toString());

		name = "xpath";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: xpath", by.toString());
	}
	
	@Test
	public void testByMatchName() {
		By by = null;
		
		String name = "name:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.name: AAA", by.toString());
	}
	
	@Test
	public void testByMatchId() {
		By by = null;
		
		String name = "id:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.id: AAA", by.toString());
	}

	@Test
	public void testByMatchClass() {
		By by = null;
		
		String name = "class:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.className: AAA", by.toString());
	}
	
	@Test
	public void testByMatchLink() {
		By by = null;
		
		String name = "link:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.linkText: AAA", by.toString());
	}
	
	@Test
	public void testByMatchTag() {
		By by = null;
		
		String name = "tag:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.tagName: AAA", by.toString());
	}

	@Test
	public void testByMatchCss() {
		By by = null;
		
		String name = "css:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.cssSelector: AAA", by.toString());
	}
	
	@Test
	public void testByMatchXpath() {
		By by = null;
		
		String name = "xpath:AAA";
		by = SeleniumBrowser.by(name);
		assertNotNull(by);
		assertEquals("By.xpath: AAA", by.toString());
	}
}
