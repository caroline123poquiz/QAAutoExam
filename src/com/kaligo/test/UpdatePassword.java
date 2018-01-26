package com.kaligo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class UpdatePassword {

	public void processUpdatePassword(WebDriver driver) {
		//Verify the label text of the change password link and click it 
		WebDriverWait waitConfirm = new WebDriverWait(driver, 50);
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
		WebElement newPasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-password")));
		String newPasswordLabelTextVerification = newPasswordLabelText.getText();
		if(newPasswordLabelTextVerification.equals(KaligoConstants.newPasswordLabelText)) {
			System.out.println("The label text beside the New Password textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text beside the New Password textbox is incorrect. It should be "+KaligoConstants.newPasswordLabelText);
		}

		//Verify the label text beside the Confirm New Password textbox
		WebElement confirmNewPasswordLabelText = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div[3]/label")));
		String confirmNewPasswordLabelTextVerification = confirmNewPasswordLabelText.getText();
		if(confirmNewPasswordLabelTextVerification.equals(KaligoConstants.confirmNewPasswordLabelText)) {
			System.out.println("The label text beside the Confirm New Password textbox is correct");
		} else {
			System.out.println("BUG: Please check. The label text beside the Confirm New Password textbox is incorrect. It should be "+KaligoConstants.confirmNewPasswordLabelText);
		}

		//Enter Current Password in Password Textbox
		WebElement enterCurrentPasswordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		if(enterCurrentPasswordTextbox.isDisplayed()) {
			enterCurrentPasswordTextbox.sendKeys(KaligoConstants.password);
			System.out.println("Current Password is successfully entered");
		} else {
			System.out.println("BUG: Unable to locate the Password textbox in Profile Page (edit mode)");
		}

		//Enter New Password in New Password textbox
		WebElement enterNewPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("new-password")));
		if(enterNewPassword.isDisplayed()) {
			enterNewPassword.sendKeys(KaligoConstants.newPassword);
			System.out.println("New Password is successfully entered");
		} else {
			System.out.println("BUG: Unable to locate the New Password textbox in Profile Page (edit mode)");
		}

		//Enter New Password in Confirm Password textbox
		WebElement confirmNewPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("confirm-password")));
		if(confirmNewPassword.isDisplayed()) {
			confirmNewPassword.sendKeys(KaligoConstants.newPassword);
			System.out.println("Confirm new Password is successfully entered");
		} else {
			System.out.println("BUG: Unable to locate the Confirm new Password textbox in Profile Page (edit mode)");
		}

		//Cancel updating the password and login to verify that the current password still works
		WebDriverWait waitCancelBtn = new WebDriverWait(driver, 50);
		WebElement cancelBtn = waitCancelBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/button[2]")));
		cancelBtn.click();
		WebElement logoutUser = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]/div")));
		logoutUser.click();
		WebDriverWait waitConfirmSpin = new WebDriverWait(driver, 50);
		waitConfirmSpin.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));	
		WebElement loginLink = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("login-signup")));
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
		
		/*//Verify that password is successfully changed and user can login with the latest password
		WebElement editMyAccountInfo = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		editMyAccountInfo.click();
		WebElement editProfile = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[1]/button")));
		editProfile.click();
		WebElement changePassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[2]/div/div/a")));
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
		WebDriverWait waitConfirmSpinner = new WebDriverWait(driver, 50);
		waitConfirmSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));	
		WebElement loginToVerifyLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("login-signup")));
		loginToVerifyLatestPassword.click();
		WebElement enterEmailAdd = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_email")));
		enterEmailAdd.sendKeys(KaligoConstants.emailAdd);
		WebElement enterLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("user_password")));
		enterLatestPassword.sendKeys(KaligoConstants.newPassword);
		WebElement signInVerifyLatestPassword = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/div/div/div[2]/form/div[3]/button")));
		signInVerifyLatestPassword.click();
		WebElement verifyMyAccountButtonIsDisplayed = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/div/nav/a/div")));
		String verifyMyAccountButtonVerification = verifyMyAccountButtonIsDisplayed.getText();
		if(verifyMyAccountButtonVerification.equalsIgnoreCase(KaligoConstants.successfulLogin)) {
			System.out.println("User has successfully logged in with the new password.");
		} else {
			System.out.println("BUG: Please check. User is not successfully logged in with the new password. User should be redirected to the page with "+KaligoConstants.successfulLogin + " button");
		}*/		
	}
}