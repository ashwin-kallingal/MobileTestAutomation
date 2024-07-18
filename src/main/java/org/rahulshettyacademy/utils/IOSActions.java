package org.rahulshettyacademy.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOSActions extends AppiumUtils {

	IOSDriver driver;

	public IOSActions(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")
	private WebElement backButton;

	public void longPress(WebElement ele) {

		Map<String, Object> param = new HashMap<>();
		param.put("element", ((RemoteWebElement) ele).getId());
		param.put("duration", 5);

		((JavascriptExecutor) driver).executeScript("mobile:touchAndHold", param);

	}

	public void scrollDown(WebElement ele) {

		Map<String, Object> param = new HashMap<>();
		param.put("element", ((RemoteWebElement) ele).getId());
		param.put("direction", "down");

		((JavascriptExecutor) driver).executeScript("mobile:scroll", param);

	}

	public void clickBackButton() {

		backButton.click();

	}

}
