package com.unbank.spider.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.Page;

public class TianyanchaSpider {

	private static Log logger = LogFactory.getLog(TianyanchaSpider.class);
	private static String url = "http://www.tianyancha.com/v2/search/%E5%8D%8E%E4%B8%BA.json?&pn=2";

	public static void main(String[] args) {
		new TianyanchaSpider().spider();
	}
	public void spider() {
		WebDriver driver = null;
		try {
			driver = fillWebDriver();
			driver.get(url);
			waitForPageLoaded(driver);
			String html = driver.getPageSource();
			System.out.println(html);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	private WebDriver fillWebDriver() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "phantomjs-2.1.1-windows/bin/phantomjs.exe"); WebDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize(); long timeout =
		 * 30000; TimeUnit timeUnit = TimeUnit.MILLISECONDS;
		 * driver.manage().timeouts().pageLoadTimeout(timeout, timeUnit);
		 */

		System.setProperty("phantomjs.binary.path", "phantomjs-2.1.1-windows/bin/phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		return driver;
	}

	public static Date timestampToDate(String beginDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdf.format(new Date(Long.parseLong(beginDate) * 1000));
		Date date = null;
		try {
			date = sdf.parse(sd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			logger.info(error);
		}
	}

	private static String formatContent(String content, String url) {
		Document document = Jsoup.parse(content, url);
		removeNoNeedElementsByCssQuery(document.body());
		formatElements(document);
		// saveImage(document, url);
		content = document.toString();
		content = replaceStockCode(content);
		content = content.replace("<html><head></head><body>", "");
		content = content.replace("</body></html>", "");
		content = content.replace("'", "");
		return content;
	}

	// 去掉不需要的HTML标签
	public static void removeNoNeedElementsByCssQuery(Element contentElement) {
		String cssQuerys[] = new String[] { "script", "style", "textarea", "select", "noscript", "input", "em" };
		for (String string : cssQuerys) {
			removeNoNeedElement(contentElement, string);
		}
	} // 去掉不想要的html 标签

	public static void removeNoNeedElement(Element element, String cssQuery) {
		if (element == null) {
			return;
		}
		Elements elements = element.select(cssQuery);
		for (Element element2 : elements) {
			element2.remove();
		}
	}

	public static void formatElements(Element contentElement) {
		// 去重属性
		removeElementAttr(contentElement);
		Elements allElements = contentElement.children();
		for (Element element : allElements) {
			removeElementAttr(element);
			if (element != null) {
				formatElements(element);
			}

		}

	}

	// 移除所有的属性

	public static void removeElementAttr(Element element) {
		if (element == null) {
			return;
		}
		Attributes attributes = element.attributes();
		for (Attribute attribute : attributes) {
			if (attribute.getKey().isEmpty()) {
				continue;
			} else if (attribute.getKey().equals("align") && attribute.getValue().equals("center")) {
				continue;
			} else if (attribute.getKey().equals("style")
					&& (attribute.getValue().toLowerCase().contains("text-align: center"))) {
				continue;
			} else if (attribute.getKey().equals("rowspan") || attribute.getKey().equals("colspan")
					|| attribute.getKey().equals("src") || attribute.getKey().equals("data-src")) {
				continue;
			} else {
				element.removeAttr(attribute.getKey());
			}
		}
	}

	public static String replaceStockCode(String content) {
		try {
			content = content.replaceAll(">\\s{0,10}", ">");
			content = content.replaceAll(">\\s{0,10}(&nbsp; ){0,}", ">");
			content = content.replaceAll(">\\s{0,10}(&nbsp;){0,}", ">");
			content = content.replaceAll(">\\s{0,10} {0,}", ">");
			content = content.replaceAll(">\\s{0,10}  {0,}", ">");
			content = content.replaceAll(">\\s{0,10}", ">");
			content = content.replaceAll("\\s{0,10}<", "<");
			content = content.replaceAll("<p></p>", "");
			content = content.trim();
		} catch (Exception e) {
			e.printStackTrace();
			return content;
		}
		return content;
	}

}
