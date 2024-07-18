package org.rahulshettyacademy.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewPage extends IOSActions {

	IOSDriver driver;

	public AlertViewPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Alert Views' AND label == 'Alert Views'")
	private WebElement alertViewPageTitle;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label== 'Text Entry'`]")
	private WebElement textEntryMenu;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
	private WebElement enterText;

	@iOSXCUITFindBy(id = "OK")
	private WebElement okButton;

	@iOSXCUITFindBy(iOSNsPredicate = "value=='Confirm / Cancel' AND label BEGINSWITH[c] 'Confirm' ")
	private WebElement confirmCancelButton;

	@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'A message' ")
	private WebElement message;

	@iOSXCUITFindBy(iOSNsPredicate = "label=='Confirm'")
	private WebElement confirmButton;

	public String alertViewFunction(String text) {
		textEntryMenu.click();
		enterText.sendKeys(text);
		okButton.click();
		confirmCancelButton.click();
		String msg = message.getText();
		confirmButton.click();
		return msg;
	}

}
