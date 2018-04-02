package com.github.kawakitan.sample.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.kawakitan.sample.selenium.browser.Browser;
import com.github.kawakitan.sample.selenium.browser.ChromeSeleniumBrowser;
import com.github.kawakitan.sample.selenium.browser.InternetExplorerSeleniumBrowser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SampleTest {

	private Browser browser;

	@Before
	public void setUp() {
//		browser = new ChromeSeleniumBrowser();
		browser = new InternetExplorerSeleniumBrowser();
		browser.initialize();
	}

	@After
	public void tearDown() {
		browser.destory();
	}

	@Test
	public void test() {
		//browser.open("http://localhost:8080/form.html");
		browser.open("http://google.co.jp");

		assertEquals("", "なまえ", browser.getValue("name"));
		assertEquals("", "なまえ", browser.getValue("name:name"));
		assertEquals("", "なまえ", browser.getValue("id:txtName"));

		assertEquals("", "123", browser.getValue("pass"));
		assertEquals("", "123", browser.getValue("name:pass"));
		assertEquals("", "123", browser.getValue("id:txtPass"));

		System.out.println("");

		try {
			Thread.sleep(5 * 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		browser.close();

	}
}
