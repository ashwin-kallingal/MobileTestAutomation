package org.rahulshettyacademy.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.rahulshettyacademy.TestUtils.iOSBaseTest;
import org.rahulshettyacademy.pageObjects.ios.AlertViewPage;
import org.rahulshettyacademy.pageObjects.ios.PickerViewPage;
import org.rahulshettyacademy.pageObjects.ios.StepperPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends iOSBaseTest {

	@Test(groups = {"Smoke"})
	public void IOSBasicTest() throws InterruptedException {

		AlertViewPage alert = catalog.clickAlertView();
		String message = alert.alertViewFunction("Ashwin Kumar");
		System.out.println("The message is :" + message);
	}

	@Test(groups = {"Regression"})
	public void IOSLongPress() throws InterruptedException {

		StepperPage step = catalog.clickStepperView();
		step.longPressCustom();

	}

	@Test(groups = {"Smoke"})
	public void IOSScroll() throws InterruptedException {

		PickerViewPage pvp = catalog.clickPickerView();
		pvp.enterRedComponentValue("40");
		pvp.enterGreenComponentValue("200");
		pvp.enterBlueComponentValue("100");

		String value = pvp.getComponentValue("Blue");
		AssertJUnit.assertEquals(value, "100");

	}

	@Test(groups = {"Regression"})
	public void IOSScrollDown() throws InterruptedException {

		catalog.clickWebView();
		Thread.sleep(10000);

	}

}
