package org.rahulshettyacademy.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.rahulshettyacademy.pageObjects.android.CartPage;
import org.rahulshettyacademy.pageObjects.android.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_2 extends AndroidBaseTest {

	@Test(dataProvider = "getData", groups = {"Regression"})
	public void clogin(HashMap<String, String> input) throws InterruptedException {

		fp.setNameField(input.get("name"));
		fp.selectGender(input.get("gender"));
		fp.selectCountry(input.get("country"));
		fp.clickLetsShopButton();
	}

	@DataProvider(name = "getData")
	public Object[][] getLoginData() throws IOException {

		// Object[][] obj = new Object[2][3];
		/*
		 * obj[0][0] = "Ashwin"; obj[0][1] = "Male"; obj[0][2] = "Argentina";
		 * 
		 * obj[1][0] = "Shwetha"; obj[1][1] = "Female"; obj[1][2] = "Argentina"; return
		 * obj;
		 */

		// return new Object[][] { { "Ashwin", "Male", "Argentina" }, { "Shwetha",
		// "Female", "Argentina" } };

		List<HashMap<String, String>> data = getJsonData(
				"//Users//ashwinkallingal//eclipse-workspace//AppiumFrameworkDesign//data//loginData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
