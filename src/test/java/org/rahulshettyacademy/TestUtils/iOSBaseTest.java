package org.rahulshettyacademy.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.rahulshettyacademy.pageObjects.ios.UIKitCatalogPage;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.rahulshettyacademy.utils.IOSActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest extends AppiumUtils{

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public UIKitCatalogPage catalog;

	// Windows Command to install .apk file
	/*
	 * go to \platform-tools in cmd adb install <.apk file path>
	 */

	@BeforeClass(alwaysRun=true)
	public UIKitCatalogPage ConfigureAppium() throws URISyntaxException, IOException {
		
		String filePath = (System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//resources//data.properties");
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : getPropertyFileData(filePath, "ipAddress");
		int  port = Integer.parseInt(System.getProperty("port") != null ? System.getProperty("port") : getPropertyFileData(filePath, "port"));
		
		//String ipAddress = getPropertyFileData(filePath, "ipAddress");   
		String portNumber = getPropertyFileData(filePath, "port");
		//int port = Integer.parseInt(portNumber);
		String iOSDeviceName = getPropertyFileData(filePath, "iOSDeviceName");
		String iOSVersionNumber =getPropertyFileData(filePath, "iOSVersion");
		
	    service = startAppiumServer(ipAddress, port);
        XCUITestOptions options = new XCUITestOptions();
		options.setApp("/Users/ashwinkallingal/eclipse-workspace/AppiumFrameworkDesign/appResource/UIKitCatalog.app");
		options.setDeviceName(iOSDeviceName);
		options.setPlatformName(iOSVersionNumber);
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));

		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return catalog = new UIKitCatalogPage(driver);

	}

	@AfterMethod(alwaysRun=true)
	
	public void post_SetUp()
	{
		IOSActions actions = new IOSActions(driver);
		actions.clickBackButton();
	}
	
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
