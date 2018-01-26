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
			System.out.println("The Login/Sign-up link is displayed in the Homepage");
		} else {
			System.out.println("BUG: Please check. The Login/Sign-up link is not displayed in the Homepage");
		}

		//find the header title and verify the label text
		WebElement headerTitle = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[1]/h3")));
		String headerVerification = headerTitle.getText();
		if(headerVerification.equals(KaligoConstants.headerText)) {
			System.out.println("The header text of the sign in modal is correct");
		} else {
			System.out.println("BUG: Please check. The header text of the sign in modal is incorrect. It should be "+KaligoConstants.headerText);
		}


		//find and verify the Email label text
		WebElement emailLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sign-in-form\"]/div[2]/form/div[1]/label")));
		String verification = emailLabelText.getText();
		if(verification.equals(KaligoConstants.emailLblText)) {
			System.out.println("The label text of the email textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text of the email textbox is incorrect. It should be "+KaligoConstants.emailLblText);
		}

		//find and verify Password label text
		WebElement passwordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[2]/label")));
		String passwordLabelTextverification = passwordLabelText.getText();
		if(passwordLabelTextverification.equals(KaligoConstants.passwordLblText)) {
			System.out.println("The label text of the Password textbox is correct.");
		} else {
			System.out.println("BUG: Please check. The label text of the Password textbox is incorrect. It should be "+KaligoConstants.passwordLblText);
		}

		//find and verify the Remember Me label text
		WebElement rememberMeLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[2]/div[2]/label")));
		String rememberMeLabelTextverification = rememberMeLabelText.getText();
		if(rememberMeLabelTextverification.equalsIgnoreCase(KaligoConstants.rememberLblMe)) {
			System.out.println("The label text beside the Remember me Checkbox is correct.");
		} else {
			System.out.println("BUG: Please check. The label text beside the Remember me Checkbox is incorrect. It should be "+KaligoConstants.rememberLblMe);
		}

		//find the verify the label text of the Sign in button
		WebElement signInLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		String signInLabelTextVerification = signInLabelText.getText();
		if(signInLabelTextVerification.equalsIgnoreCase(KaligoConstants.signInButtonLabelText)) {
			System.out.println("The label text of the sign in button is correct");
		} else {
			System.out.println("BUG: Please check.The label text of the sign in button is incorrect. It should be "+KaligoConstants.signInButtonLabelText);
		}

		//find and verify the label text of the Sign Up button
		WebElement signUpLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.id("signupButton")));
		String signUpLabelTextVerification = signUpLabelText.getText();
		if(signUpLabelTextVerification.equalsIgnoreCase(KaligoConstants.signUpLinkLabelText)) {
			System.out.println("The label text of the Sign up button is correct");
		} else {
			System.out.println("BUG: Please check. The label text of the Sign up button is incorrect. It should be "+KaligoConstants.signUpLinkLabelText);
		}

		//find and verify the label text of the Forgot Your Password button
		WebElement forgotYourPasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgetpasswordButton")));
		String forgotYourPasswordLabelTextVerification = forgotYourPasswordLabelText.getText();
		if(forgotYourPasswordLabelTextVerification.equalsIgnoreCase(KaligoConstants.forgotYourPasswordLabelText)) {
			System.out.println("The label text of the Forgot Your Password button is correct");
		} else {
			System.out.println("BUG: Please check. The label text of the Forgot Your Password button is incorrect. It should be "+KaligoConstants.forgotYourPasswordLabelText);
		}

		//Verify that user is successfully redirected to the Sign Up window when the Sign Up button is clicked
		WebElement clickSignUpLink = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("signupButton")));
		clickSignUpLink.click();
		WebElement signUpWindow = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[15]/div/div/div/div[1]/h3")));
		String signUpWindowVerification = signUpWindow.getText();
		if(signUpWindowVerification.equalsIgnoreCase(KaligoConstants.signUpLinkLabelText)) {
			System.out.println("User is successfully redirected to the Sign Up Window");
		} else {
			System.out.println("BUG: Please check. User is redirected to the wrong window. User should be redirected to "+ KaligoConstants.signUpLinkLabelText + " Window");
		}
		WebElement closeSignUpWindow = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div/div/div/div[1]/a")));
		closeSignUpWindow.click();

		//Verify that user is successfully redirected to the Forgot your password window when the Forgot your password button is clicked
		WebElement clickForgotYourPasswordButton = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("forgetpasswordButton")));
		clickForgotYourPasswordButton.click();
		WebElement forgotYourPasswordUpWindow = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[15]/div/div/div/div[1]/h3")));
		String forgotYourPasswordUpWindowVerification = forgotYourPasswordUpWindow.getText();
		if(forgotYourPasswordUpWindowVerification.equalsIgnoreCase(KaligoConstants.forgotYourPasswordLabelText)) {
			System.out.println("User is successfully redirected to the Forgot Your Password  Window");
		} else {
			System.out.println("BUG: Please check. User is redirected to the wrong window. User should be redirected to " + KaligoConstants.forgotYourPasswordLabelText + " Window");
		}
		WebElement closeForgotYourPasswordWindow = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div/div/div/div[1]/a")));
		closeForgotYourPasswordWindow.click();


		//find the Email textbox and enter valid email address
		WebElement emailTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		if(emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys(KaligoConstants.emailAdd);
			System.out.println("Email Add textbox is displayed and a valid email address is successfully entered");
		} else {
			System.out.println("BUG: Email Add textbox is not displayed");
		}
		

		//find the Password textbox and enter valid Password
		WebElement passwordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		if(passwordTextbox.isDisplayed()) {
			passwordTextbox.sendKeys(KaligoConstants.password);
			System.out.println("Password textbox is displayed and a valid password is successfully entered");
		}else {
			System.out.println("BUG: Password textbox is not displayed");
		}

		//find the Remember me checkbox
		WebElement rememberMeCheckbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_remember_me")));
		if(rememberMeCheckbox.isDisplayed()) {
			rememberMeCheckbox.click();
			System.out.println("Remember me checkbox is displayed and successfully ticked");
		}else {
			System.out.println("BUG: Remember me textbox is not displayed");
		}

		//locate the close icon and close the sign in window
		WebElement closeSignInWindow = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[1]/a")));
		if(closeSignInWindow.isDisplayed()) {
			closeSignInWindow.click();
			System.out.println("Close icon is located and the sign in pop up window is closed.");
		}else {
			System.out.println("BUG: Unable to locate the close icon");
		}

		//click the login/sign-up link again and enter valid credentials
		loginLink.click();
		WebElement findEmailTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		findEmailTextbox.sendKeys(KaligoConstants.emailAdd);
		WebElement findPasswordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		findPasswordTextbox.sendKeys(KaligoConstants.password);
		WebElement findRememberMeCheckbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_remember_me")));
		findRememberMeCheckbox.click();

		//find the Sign In button and click
		WebElement signInButton = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		if(signInButton.isDisplayed()) {
			signInButton.click();
			System.out.println("The sign in button is displayed");
		}else {
			System.out.println("BUG: The sign in button is not displayed");
		}

		WebDriverWait waitConfirmSpin = new WebDriverWait(driver, 90);
		waitConfirmSpin.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));

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
