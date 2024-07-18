package org.rahulshettyacademy.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage fp;

	// Windows Command to install .apk file
	/*
	 * go to \platform-tools in cmd adb install <.apk file path>
	 */

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws URISyntaxException, IOException {

		String filePath = (System.getProperty("user.dir")
				+ "//src//main//java//org//rahulshettyacademy//resources//data.properties");
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : getPropertyFileData(filePath, "ipAddress");
		int  port = Integer.parseInt(System.getProperty("port") != null ? System.getProperty("port") : getPropertyFileData(filePath, "port"));
		
		//String ipAddress = getPropertyFileData(filePath, "ipAddress");
		String portNumber = getPropertyFileData(filePath, "port");
		//int port = Integer.parseInt(portNumber);
		String androidDeviceName = getPropertyFileData(filePath, "androidDeviceName");

		//service = startAppiumServer(ipAddress, port);

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(androidDeviceName);
		options.setApp("/Users/ashwinkallingal/eclipse-workspace/Appium/src/test/java/resources/General-Store.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		fp = new FormPage(driver);

	}

	/*
	 * @BeforeMethod(alwaysRun = true) public void pre_Set() {
	 * 
	 * // adb shell dumpsys window | grep -E 'mCurrentFocus' - MAC // adb shell
	 * dumpsys window | find "mCurrentFocus" - Windows
	 * 
	 * // Activity activity = new Activity("com.androidsample.generalstore", //
	 * "com.androidsample.generalstore.MainActivity");
	 * 
	 * 
	 * 
	 * try { ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
	 * ImmutableMap.of("intent",
	 * "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
	 * )); System.out.println("Successfully started activity."); } catch (Exception
	 * e) { System.out.println("Failed to start activity: " + e.getMessage());
	 * e.printStackTrace(); } }
	 */

	@AfterMethod(alwaysRun = true)
	public void post_Set() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		// service.stop();

	}

	public void getActivityForPreferenceDependancy() {

		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
	}

	public void waitForVisibilityElementPresentByAttributeValue(String attribute, String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), attribute, value));
	}

}
