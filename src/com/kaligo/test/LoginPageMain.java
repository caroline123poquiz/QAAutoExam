package com.kaligo.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class LoginPageMain  {


	public static void main (String[] args) throws InterruptedException {
		try {
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream("resources/config.properties");
			prop.load(input);
			String geckoDriver = prop.getProperty("gecko.driver.path");
			//launch firefox browser 
			System.setProperty("webdriver.gecko.driver", geckoDriver);	
			WebDriver driver = new FirefoxDriver();
			LoginPageProcess process = new LoginPageProcess();
			UpdateProfile update = new UpdateProfile();
			NegativeTestLoginPage negative = new NegativeTestLoginPage();
			NegativeTestUpdateProfile negativeScenarios = new NegativeTestUpdateProfile();
			//Launch the Kaligo Website
			driver.get("https://www.kaligo.com/"); // url
			//call processRegistration method and pass the webdriver object, username and password
			WebDriverWait waitConfirm = new WebDriverWait(driver, 20);
			waitConfirm.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
			process.processRegistration(driver, KaligoConstants.emailAdd, KaligoConstants.password);
			update.processUpdateAccount(driver);
			negative.testNegative(driver, KaligoConstants.emailAdd, KaligoConstants.password);
			negativeScenarios.testNegativeUpdateProfile(driver, KaligoConstants.emailAdd, KaligoConstants.password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error encountered:" + e);
		}
	}

}
