package com.kaligo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class NegativeTestLoginPage {

	public void testNegative(WebDriver driver, String emailAdd, String password) throws InterruptedException {

		//find and click the Login/SignUp link if found after logging out
		WebDriverWait waitConfirm = new WebDriverWait(driver, 90);
		waitConfirm.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		WebDriverWait waitConfirmLogIn = new WebDriverWait(driver, 50);		
		WebElement loginlink = waitConfirmLogIn.until(ExpectedConditions.elementToBeClickable(By.id("login-signup")));
		if(loginlink.isDisplayed()) {
			loginlink.click();
			System.out.println("The Login/Sign-up link is displayed");
		} else {
			System.out.println("The Login/Sign-up link is not displayed");
		}

		//click the sign in button with blank email and blank password - validation message should display
		WebElement signInButton = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		signInButton.isDisplayed();
		signInButton.click();
		WebElement validationMessage = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/div")));
		String validationMessageVerification = validationMessage.getText();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Both Email and Password textboxes are blank. '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//verify that an error message is displayed when email textbox is blank
		WebElement passwordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		passwordTextbox.isDisplayed();
		passwordTextbox.sendKeys(KaligoConstants.password);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Email textbox is blank, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//verify that an error message is displayed when password textbox is blank and a valid email add has been entered
		WebElement usernameTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		usernameTextbox.isDisplayed();
		passwordTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.emailAdd);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Password textbox is blank, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//enter invalid email add and check the validation message
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.invalidEmailAdd);
		passwordTextbox.sendKeys(KaligoConstants.password);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Invalid email add has been entered, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//enter incorrect email add and check the validation message
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.incorrectEmailAdd);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Incorrect email add has been entered, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//enter unregistered email add and check the validation message
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.notYetRegisteredEmailAdd);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Unregistered email add has been entered, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//enter incorrect password and check the validation message
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.emailAdd);
		passwordTextbox.clear();
		passwordTextbox.sendKeys(KaligoConstants.incorrectPassword);
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Incorrect password has been entered, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//enter password in big caps add and check the validation message
		passwordTextbox.clear();
		passwordTextbox.sendKeys(KaligoConstants.password.toUpperCase());
		signInButton.click();
		if(validationMessageVerification.equals(KaligoConstants.validationMessage)) {
			System.out.println("Incorrect password (big caps) has been entered, '" + KaligoConstants.validationMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Missing validation message.");
		}

		//3 invalid attempts - user should not get locked out as per system behavior
		Thread.sleep(3000);
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.emailAdd);
		passwordTextbox.clear();
		passwordTextbox.sendKeys(KaligoConstants.incorrectPassword);
		signInButton.click();
		usernameTextbox.clear();
		usernameTextbox.sendKeys(KaligoConstants.incorrectEmailAdd);
		passwordTextbox.clear();
		passwordTextbox.sendKeys(KaligoConstants.password);
		signInButton.click();
		passwordTextbox.clear();
		passwordTextbox.sendKeys(KaligoConstants.specialCharactersPassword);
		signInButton.click();
		usernameTextbox.clear();
		passwordTextbox.clear();
		usernameTextbox.sendKeys(emailAdd);
		passwordTextbox.sendKeys(KaligoConstants.password);
		WebElement rememberMeCheckbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_remember_me")));
		rememberMeCheckbox.isDisplayed();
		rememberMeCheckbox.click();
		usernameTextbox.click();
		passwordTextbox.click();
		Thread.sleep(3000);
		WebDriverWait waitConfirmButton = new WebDriverWait(driver, 90);
		WebElement signIn = waitConfirmButton.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		if(signIn.isDisplayed()) {
			System.out.println("Sign In button is located");
			signIn.click();	
		} else {
			System.out.println("BUG: Please check. Unable to locate the sign in button");
		}
		WebElement logoutUser = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]/div")));
		if(logoutUser.isDisplayed()) {
			System.out.println("User is successfully logged in after 3 invalid attempts.");
			logoutUser.click();
		}else {
			System.out.println("BUG: Please check. User is not successfully logged after 3 invalid attempts.");
		}

		//enter Email Add in big caps - user should be successfully logged in
		Thread.sleep(3000);
		WebDriverWait waitConfirmv2 = new WebDriverWait(driver, 90);
		waitConfirmv2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		WebDriverWait waitConfirmLoginBtn = new WebDriverWait(driver, 90);
		WebElement loginLink = waitConfirmLoginBtn.until(ExpectedConditions.elementToBeClickable(By.id("login-signup")));
		if(loginLink.isDisplayed()) {
			System.out.println("The Login/SignUp link is located");
			loginLink.click();	
		} else {
			System.out.println("Unable to locate Login/SignUp and user cannot login");
		}
		WebElement emailTextboxv2 = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		emailTextboxv2.sendKeys(KaligoConstants.emailAdd.toUpperCase());
		WebElement enterValidPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		enterValidPassword.sendKeys(KaligoConstants.password);
		WebElement signInBttn = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		if(signInBttn.isDisplayed()) {
			System.out.println("Login button is located");
			signInBttn.click();	
			System.out.println("User has successfully logged in");
		} else {
			System.out.println("Unable to locate the Sign In button");
		}
	}
}
