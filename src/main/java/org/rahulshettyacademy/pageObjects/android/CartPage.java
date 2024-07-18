package org.rahulshettyacademy.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productsInCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productsPriceListInCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement getDisplayedAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsAndConditionLink;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement closeButton;

	@AndroidFindBy(xpath = "android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
	private WebElement checkBox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement visitWebsiteButton;

	public List<WebElement> getProductsInCart() {
		return productsInCart;
	}

	public List<WebElement> getProductsPriceInCart() {
		return productsPriceListInCart;
	}

	public void longPressTermsLink() {
		longPress(termsAndConditionLink);
	}

	public void clickCloseButton() {
		waitForVisibilityElementPresent(driver, closeButton);
		closeButton.click();
	}

	public void clickCheckBox() {
		checkBox.click();
	}

	public void clickVisitWebsiteButton() {
		visitWebsiteButton.click();
	}

	/*
	 * public List<WebElement> productList(){ List<WebElement> productInCartList =
	 * getProductsPriceInCart(); return productInCartList; }
	 */

	public double getProductSum() {
		int cartSize = getProductsPriceInCart().size();
		System.out.println("Cart Size is:" + cartSize);
		double totalSum = 0;

		for (int i = 0; i < cartSize; i++) {
			String amt = getProductsPriceInCart().get(i).getText();
			double amount = getFormattedString(amt);
			totalSum = totalSum + amount;
		}
		return totalSum;
	}

	public double getTotalAmountDisplayedInCart() {
		String disAmt = getDisplayedAmount.getText();
		double displayedAmount = getFormattedString(disAmt);
		return displayedAmount;
	}
}
