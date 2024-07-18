package org.rahulshettyacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.ReferenceType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	public AppiumDriverLocalService service;

	public double getFormattedString(String value) {

		double result = Double.parseDouble(value.substring(1).trim());
		return result;

	}

	public void waitForVisibilityElementPresent(AppiumDriver driver, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int portNumber) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib/main.js"))
				.withIPAddress(ipAddress).usingPort(portNumber).build();
		service.start();
		return service;
	}

	public String getPropertyFileData(String filePath, String key) throws IOException {
		String value = "";
		Properties prop = new Properties();
		prop.load(new FileInputStream(filePath));
		value = prop.getProperty(key);
		return value;

	}

	public String getScreenshotPath(AppiumDriver driver, String screenshotName) throws IOException {

		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "//screenshots//" + screenshotName + ".png";
		FileUtils.copyFile(srcFile, new File((destFile)));
		return destFile;

	}

}
