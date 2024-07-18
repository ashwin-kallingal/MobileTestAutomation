package org.rahulshettyacademy.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement yourName;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleGender;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleGender;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryDropdown;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;

	public void setNameField(String name) {
		yourName.sendKeys(name);
		driver.hideKeyboard();

	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			maleGender.click();
		} else {
			femaleGender.click();
		}
	}

	public void selectCountry(String country) {
		countryDropdown.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();

	}

	public void clickLetsShopButton() {
		letsShopButton.click();

	}

	public ProductPage loginToApp(String name, String gender, String country) {
		setNameField(name);
		selectGender(gender);
		selectCountry(country);
		clickLetsShopButton();
		return new ProductPage(driver);
	}
}
