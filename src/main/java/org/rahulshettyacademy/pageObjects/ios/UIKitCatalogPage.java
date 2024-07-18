package org.rahulshettyacademy.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class UIKitCatalogPage extends IOSActions {

	IOSDriver driver;

	public UIKitCatalogPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(accessibility = "Alert Views")
	private WebElement alertViewsMenu;

	@iOSXCUITFindBy(accessibility = "Picker View")
	private WebElement pickerViewsMenu;

	@iOSXCUITFindBy(accessibility = "Steppers")
	private WebElement stepperViewsMenu;

	@iOSXCUITFindBy(accessibility = "Web View")
	private WebElement webViewsMenu;

	public AlertViewPage clickAlertView() throws InterruptedException {
		alertViewsMenu.click();
		return new AlertViewPage(driver);
	}

	public PickerViewPage clickPickerView() {
		pickerViewsMenu.click();
		return new PickerViewPage(driver);
	}

	public StepperPage clickStepperView() {
		stepperViewsMenu.click();
		return new StepperPage(driver);
	}

	public void clickWebView() {
		scrollDown(webViewsMenu);
		webViewsMenu.click();
	}

}
