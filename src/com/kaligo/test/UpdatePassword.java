package com.kaligo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;



public class UpdatePassword {

	public void processUpdatePassword(WebDriver driver) throws InterruptedException {
		//Verify the label text of the change password link and click it 
		WebDriverWait waitConfirm = new WebDriverWait(driver, 90);
		WebElement changePasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div/div/a")));
		String changePasswordVerification = changePasswordLabelText.getText();
		if(changePasswordVerification.equals(KaligoConstants.changeYourPasswordLabelText)) {
			System.out.println("The label text of the change password link is correct");
		} else {
			System.out.println("BUG: Please check. The label text of the change password link is incorrect. It should be "+KaligoConstants.changeYourPasswordLabelText);
		}
		changePasswordLabelText.click();

		//Verify the label text beside the Current Password textbox
		WebElement passwordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[1]/label")));
		String passwordLabelTextVerification = passwordLabelText.getText();
		if(passwordLabelTextVerification.equals(KaligoConstants.passwordLblText)) {
			System.out.println("The label text beside the Password textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text beside the Password textbox is incorrect. It should be "+KaligoConstants.passwordLblText);
		}

		//Verify the label text beside the New Password textbox
		WebElement newPasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[2]/label")));
		String newPasswordLabelTextVerification = newPasswordLabelText.getText();
		if(newPasswordLabelTextVerification.equals(KaligoConstants.newPasswordLabelText)) {
			System.out.println("The label text beside the New Password textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text beside the New Password textbox is incorrect. It should be "+KaligoConstants.newPasswordLabelText+".");
		}

		//Verify the label text beside the Confirm New Password textbox
		WebElement confirmNewPasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[3]/label")));
		String confirmNewPasswordLabelTextVerification = confirmNewPasswordLabelText.getText();
		if(confirmNewPasswordLabelTextVerification.equals(KaligoConstants.confirmNewPasswordLabelText)) {
			System.out.println("The label text beside the Confirm New Password textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text beside the Confirm New Password textbox is incorrect. It should be "+KaligoConstants.confirmNewPasswordLabelText);
		}

		//Verify that Password is a required field
		WebElement passwordShouldBeRequired = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		passwordShouldBeRequired.click();
		passwordShouldBeRequired.sendKeys("test");
		passwordShouldBeRequired.clear();
		WebElement savePassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/button[1]")));
		savePassword.click();
		WebElement validationMessage = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[1]/div/div/div/span")));
		String validationMessageVerification = validationMessage.getText();
		if(validationMessageVerification.equals(KaligoConstants.emptyPasswordValidationMessage)) {
			System.out.println("A validation message stating that: '" + KaligoConstants.emptyPasswordValidationMessage + "' is displayed when Password is empty.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.emptyPasswordValidationMessage + " should display when Password is empty.");
		}

		//Verify that New Password is a required field
		//WebDriverWait waitConfirm = new WebDriverWait(driver, 90);
		WebElement newPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("new-password")));
		newPassword.click();
		newPassword.sendKeys("test");
		newPassword.clear();
		savePassword.click();
		WebElement newPasswordIsRequired = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[2]/div/div/div/span")));
		String newPasswordIsRequiredVerification = newPasswordIsRequired.getText();
		if(newPasswordIsRequiredVerification.equals(KaligoConstants.emptyNewPasswordValidationMessage)) {
			System.out.println("A validation message stating that: '" + KaligoConstants.emptyNewPasswordValidationMessage + "' is displayed when New Password textbox is empty.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.emptyNewPasswordValidationMessage + " should display when New Password textbox is empty.");
		}

		//Verify that Confirm Password is a required field
		WebElement confirmPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("confirm-password")));
		confirmPassword.click();
		confirmPassword.sendKeys("test");
		confirmPassword.clear();
		savePassword.click();
		WebElement confirmPasswordIsRequired = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[3]/div/div/div/span")));
		String confirmPasswordIsRequiredVerification = confirmPasswordIsRequired.getText();
		if(confirmPasswordIsRequiredVerification.equals(KaligoConstants.confirmNewPasswordValidationMessage)) {
			System.out.println("A validation message stating that: '" + KaligoConstants.confirmNewPasswordValidationMessage + "' is displayed when Confirm Password textbox is empty.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.confirmNewPasswordValidationMessage + " should display when Confirm Password textbox is empty.");
		}

		//Verify that an error message is displayed when Password is incorrect
		passwordShouldBeRequired.sendKeys(KaligoConstants.password+"1");
		newPassword.sendKeys(KaligoConstants.newPassword);
		confirmPassword.sendKeys(KaligoConstants.newPassword);
		savePassword.click();
		WebElement errorMessageForIncorrectPassword = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div/div[2]/span")));
		String errorMessageForIncorrectPasswordVerification = errorMessageForIncorrectPassword.getText();
		if(errorMessageForIncorrectPasswordVerification.equals(KaligoConstants.errorMessageWhenPasswordIsIncorrect)) {
			System.out.println("An error message stating that: '" + KaligoConstants.errorMessageWhenPasswordIsIncorrect + "' is displayed when incorrect Password is entered.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.errorMessageWhenPasswordIsIncorrect + " should display when incorrect Password is entered.");
		}

		//Verify that an error message is displayed when New Password doesn't match the entered value in Confirm Password textbox
		passwordShouldBeRequired.clear();
		newPassword.clear();
		passwordShouldBeRequired.sendKeys(KaligoConstants.password);
		newPassword.sendKeys(KaligoConstants.newPassword+"1");
		savePassword.click();
		WebElement errorMessageIncorrectNewPassword = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[3]/div/div/div/span")));
		String errorMessageNewPasswordDoesNotMatchConfirmPassword = errorMessageIncorrectNewPassword.getText();
		if(errorMessageNewPasswordDoesNotMatchConfirmPassword.equals(KaligoConstants.errorMessageWhenNewPasswordDoesNotMatchConfirmPassword)) {
			System.out.println("An error message stating that: '" + KaligoConstants.errorMessageWhenNewPasswordDoesNotMatchConfirmPassword + "' is displayed when New Password does not match Confirm Password value.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.errorMessageWhenPasswordIsIncorrect + " should display when New Password does not match Confirm Password value.");
		}

		//Verify that an error message is displayed when Confirm Password doesn't match the entered value in New Password textbox
		newPassword.clear();
		confirmPassword.clear();
		newPassword.sendKeys(KaligoConstants.newPassword);
		confirmPassword.sendKeys(KaligoConstants.newPassword+"1");
		savePassword.click();
		WebElement errorMessageIncorrectConfirmPassword = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[3]/div/div/div/span")));
		String errorMessageConfirmPasswordDoesNotMatchNewPassword = errorMessageIncorrectConfirmPassword.getText();
		if(errorMessageConfirmPasswordDoesNotMatchNewPassword.equals(KaligoConstants.errorMessageWhenConfirmPasswordDoesNotMatchNewConfirmPassword)) {
			System.out.println("An error message stating that: '" + KaligoConstants.errorMessageWhenConfirmPasswordDoesNotMatchNewConfirmPassword + "' is displayed when Confirm Password does not match New Password value.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.errorMessageWhenConfirmPasswordDoesNotMatchNewConfirmPassword + " should display when Confirm Password does not match New Password value.");
		}

		//Verify that an error message is displayed when New Password is less than 8 characters
		newPassword.clear();
		confirmPassword.clear();
		newPassword.sendKeys(KaligoConstants.newPasswordLessThan8Characters);
		confirmPassword.sendKeys(KaligoConstants.password);
		savePassword.click();
		WebElement errorMessageNewPasswordLessThan8Characters = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[2]/div/div/div/span")));
		String newPasswordLessThan8Characters = errorMessageNewPasswordLessThan8Characters.getText();
		if(newPasswordLessThan8Characters.equals(KaligoConstants.errorMessageWhenNewPasswordLessThan8Characters)) {
			System.out.println("An error message stating that: '" + KaligoConstants.errorMessageWhenNewPasswordLessThan8Characters + "' is displayed when New Password is less than 8 characters.");
		} else {
			System.out.println("BUG: Please check. Validation message " + KaligoConstants.errorMessageWhenNewPasswordLessThan8Characters + " should display when New Password is less than 8 characters.");
		}
		
		//Cancel updating the password and login to verify that the current password still works
		passwordShouldBeRequired.clear();
		newPassword.clear();
		confirmPassword.clear();
		passwordShouldBeRequired.sendKeys(KaligoConstants.password);
		newPassword.sendKeys(KaligoConstants.newPassword);
		confirmPassword.sendKeys(KaligoConstants.newPassword);
		WebDriverWait waitCancelBtn = new WebDriverWait(driver, 50);
		WebElement cancelBtn = waitCancelBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/button[2]")));
		cancelBtn.click();
		WebElement logoutUser = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]/div")));
		logoutUser.click();
		WebDriverWait waitConfirmSpin = new WebDriverWait(driver, 90);
		waitConfirmSpin.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		Thread.sleep(3000);
		WebDriverWait waitConfirmLoginLink = new WebDriverWait(driver, 90);
		WebElement loginLink = waitConfirmLoginLink.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[2]/div")));
		loginLink.click();
		WebElement clickEmailTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		clickEmailTextbox.sendKeys(KaligoConstants.emailAdd);
		WebElement clickPasswordTextbox= waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		clickPasswordTextbox.sendKeys(KaligoConstants.password);
		WebElement signInUser = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		signInUser.click();
		WebElement myAccountLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		String myAccountLabelVerification = myAccountLabelText.getText();
		if(myAccountLabelVerification.equalsIgnoreCase(KaligoConstants.successfulLogin)) {
			System.out.println("User has successfully logged in with current password. Current Password was retained.");
		} else {
			System.out.println("BUG: Please check. User is not successfully logged in.  User should be redirected to the page with "+KaligoConstants.successfulLogin + " button");
		}

		//Verify that password is successfully changed and user can login with the latest password
		WebElement editMyAccountInfo = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		editMyAccountInfo.click();
		WebDriverWait waitConfirmSpinner = new WebDriverWait(driver, 100);
		waitConfirmSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));	
		WebDriverWait waitConfirmChangePassword = new WebDriverWait(driver, 150);
		WebElement changePassword = waitConfirmChangePassword.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div/div/a")));
		changePassword.click();
		WebElement enterCurrentPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		enterCurrentPassword.sendKeys(KaligoConstants.password);
		WebElement enterNewPasswordv2 = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("new-password")));
		enterNewPasswordv2.sendKeys(KaligoConstants.newPassword);
		WebElement enterConfirmPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("confirm-password")));
		enterConfirmPassword.sendKeys(KaligoConstants.newPassword);
		WebElement clickChangePassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/button[1]")));
		clickChangePassword.click();
		WebElement logoutUserVerifyLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]/div")));
		logoutUserVerifyLatestPassword.click();
		waitConfirmSpinner = new WebDriverWait(driver, 150);
		waitConfirmSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		Thread.sleep(3000);
		WebDriverWait loginToVerifyLatestPassword = new WebDriverWait(driver, 150);
		WebElement loginToVerifyLatestVerification = loginToVerifyLatestPassword.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[2]/div")));
		loginToVerifyLatestVerification.click();
		WebElement enterEmailAdd = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		enterEmailAdd.sendKeys(KaligoConstants.emailAdd);
		WebElement enterLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		enterLatestPassword.sendKeys(KaligoConstants.newPassword);
		WebElement signInVerifyLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		signInVerifyLatestPassword.click();
		WebElement verifyMyAccountButtonIsDisplayed = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		String verifyMyAccountButtonVerification = verifyMyAccountButtonIsDisplayed.getText();
		if(verifyMyAccountButtonVerification.equalsIgnoreCase(KaligoConstants.successfulLogin)) {
			System.out.println("After changing the password, user can successfully logged in with the new password.");
		} else {
			System.out.println("BUG: Please check. User is not successfully logged in with the new password. User should be redirected to the page with "+KaligoConstants.successfulLogin + " button");
		}
		//Change the password from old to new
		WebElement editMyAccount = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		editMyAccount.click();
		WebDriverWait waitSpin = new WebDriverWait(driver, 150);
		waitSpin.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));	
		WebDriverWait waitConfirmChangePasswordToDisplay = new WebDriverWait(driver, 150);
		WebElement changePasswordAgain = waitConfirmChangePasswordToDisplay.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div/div/a")));
		changePasswordAgain.click();
		WebElement enterCurrentPasswordAgain = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		enterCurrentPasswordAgain.sendKeys(KaligoConstants.newPassword);
		WebElement enterNewPasswordAgain = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("new-password")));
		enterNewPasswordAgain.sendKeys(KaligoConstants.password);
		WebElement enterConfirmPasswordAgain = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("confirm-password")));
		enterConfirmPasswordAgain.sendKeys(KaligoConstants.password);
		WebElement clickChangePasswordAgain = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/button[1]")));
		clickChangePasswordAgain.click();
		WebElement logoutUserAgain = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]/div")));
		logoutUserAgain.click();
	}
}