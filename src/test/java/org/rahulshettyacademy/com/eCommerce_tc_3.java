package org.rahulshettyacademy.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.rahulshettyacademy.pageObjects.android.CartPage;
import org.rahulshettyacademy.pageObjects.android.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_3 extends AndroidBaseTest {

	@Test(groups = {"Smoke"})
	public void alogin() throws InterruptedException {

		fp.setNameField("Shwetha GN");
		fp.selectGender("Female");
		fp.selectCountry("Australia");
		fp.clickLetsShopButton();
		}
	
	
	@Test(groups = {"Smoke"})
	public void zlogin() throws InterruptedException {

		fp.setNameField("Kalavathi");
		fp.selectGender("Female");
		fp.selectCountry("Australia");
		fp.clickLetsShopButton();
		}
}
