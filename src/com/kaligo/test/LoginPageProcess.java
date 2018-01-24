package com.kaligo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class LoginPageProcess {



	public void processRegistration(WebDriver driver, String emailAdd, String password) throws InterruptedException {

		//find and click the Login/SignUp link if found
		WebDriverWait waitConfirm = new WebDriverWait(driver, 50);		
		WebElement loginLink = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("login-signup")));
		//WebElement loginLink = driver.findElement(By.id("login-signup"));
		if(loginLink.isDisplayed()) {
			loginLink.click();
			System.out.println("The Login/Sign-up link is displayed");
		} else {
			System.out.println("The Login/Sign-up link is not displayed");
		}
		

		//find the Email label text
		WebElement emailLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sign-in-form\"]/div[2]/form/div[1]/label")));
		String verification = emailLabelText.getText();
		if(verification.equals(KaligoConstants.emailLblText)) {
			System.out.println("Email label text is displayed");
		} else {
			System.out.println("BUG: Email label text is not displayed");
		}

		//find the Email textbox and enter valid email address
		WebElement emailTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		if(emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys(emailAdd);
			System.out.println("Email Add textbox is displayed and a valid email address is successfully entered");
		} else {
			System.out.println("BUG: Email Add textbox is not displayed");
		}


		//find the Password label text
		WebElement passwordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[2]/label")));
		String passwordLabelTextverification = passwordLabelText.getText();
		if(passwordLabelTextverification.equals(KaligoConstants.passwordLblText)) {
			System.out.println("Password label text is displayed");
		} else {
			System.out.println("BUG: Password label text is not displayed");
		}

		//find the Password textbox and enter valid Password
		WebElement passwordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		if(passwordTextbox.isDisplayed()) {
			passwordTextbox.sendKeys(password);
			System.out.println("Password textbox is displayed and a valid password is successfully entered");
		}else {
			System.out.println("BUG: Password textbox is not displayed");
		}

		//find the Remember Me label text
		WebElement rememberMeLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[2]/div[2]/label")));
		String rememberMeLabelTextverification = rememberMeLabelText.getText();
		if(rememberMeLabelTextverification.equalsIgnoreCase(KaligoConstants.rememberLblMe)) {
			System.out.println("Remember me label text is displayed");
		} else {
			System.out.println("BUG: Remember me label text is not displayed.");
		}

		//find the Remember me checkbox
		WebElement rememberMeCheckbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_remember_me")));
		if(rememberMeCheckbox.isDisplayed()) {
			rememberMeCheckbox.click();
			System.out.println("Remember me checkbox is displayed and successfully ticked");
		}else {
			System.out.println("BUG: Remember me textbox is not displayed");
		}

		//find the Sign In button and click
		WebElement signInButton = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		if(signInButton.isDisplayed()) {
			signInButton.click();
			System.out.println("The sign in button is displayed");
		}else {
			System.out.println("BUG: The sign in button is not displayed");
		}

		//Find and click My Account Menu
		WebElement editAccountInfo = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		if(editAccountInfo.isDisplayed()) {
			editAccountInfo.click();
			System.out.println("My Account profile is displayed");
		}else {
			System.out.println("BUG: Unable to find My Account link");
		}

		//Check Email Address in the profile page
		WebElement emailAddressValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[6]/div")));
		String emailAddressValueVerificationViewMode = emailAddressValueViewMode.getText();
		if(emailAddressValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.emailAdd)) {
			System.out.println("The displayed Email Address in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Email Address in the Profile Page(view mode) is incorrect");
		} 
	}

}
