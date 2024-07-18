package org.rahulshettyacademy.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PickerViewPage extends IOSActions {

	IOSDriver driver;

	public PickerViewPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(accessibility = "Red color component value")
	private WebElement redScrollComponent;

	@iOSXCUITFindBy(accessibility = "Green color component value")
	private WebElement greenScrollComponent;

	@iOSXCUITFindBy(accessibility = "Blue color component value")
	private WebElement blueScrollComponent;

	public void enterRedComponentValue(String text) {
		redScrollComponent.sendKeys(text);
	}

	public void enterGreenComponentValue(String text) {
		greenScrollComponent.sendKeys(text);
	}

	public void enterBlueComponentValue(String text) {
		blueScrollComponent.sendKeys(text);
	}

	public String getComponentValue(String colour) {
		String getColour = null;
		if (colour.equalsIgnoreCase("Red")) {
			getColour = redScrollComponent.getText();
		} else if (colour.equalsIgnoreCase("Green")) {
			getColour = greenScrollComponent.getText();
		} else if (colour.equalsIgnoreCase("Blue")) {
			getColour = blueScrollComponent.getText();
		}
		return getColour;
	}

}
