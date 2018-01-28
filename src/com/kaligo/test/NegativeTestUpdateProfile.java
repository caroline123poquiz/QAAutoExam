package com.kaligo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class NegativeTestUpdateProfile {

	public void testNegativeUpdateProfile(WebDriver driver, String emailadd, String password) {

		//Find the "Edit Profile" button and click it
		WebDriverWait waitConfirmSpinner = new WebDriverWait(driver, 90);
		waitConfirmSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		WebDriverWait waitEditProfileBtn = new WebDriverWait(driver, 90);
		WebElement editProfile = waitEditProfileBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[1]/button")));
		if(editProfile.isDisplayed()) {
			editProfile.click();
			System.out.println("Edit profile button is displayed and is successfully clicked");
		}else {
			System.out.println("BUG: Unable to locate Edit Profile");
		}

		//Verify that First Name is a required field
		WebDriverWait waitConfirm = new WebDriverWait(driver, 90);
		WebElement editFirstName = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
		if(editFirstName.isDisplayed()) {
			editFirstName.clear();
			System.out.println("First Name is located and values are deleted");
		}else {
			System.out.println("BUG: Unable to locate/update first name");
		}
		WebElement requiredFieldMessage = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[3]/div/div/div/span")));
		String requiredFieldMessageVerification = requiredFieldMessage.getText();
		if(requiredFieldMessageVerification.equals(KaligoConstants.requiredFieldMessage)) {
			System.out.println("First Name is empty hence '" + KaligoConstants.requiredFieldMessage + "' is displayed.");
		} else {
			System.out.println("BUG: Please check. A warning message" + KaligoConstants.requiredFieldMessage + "should display when First Name textbox is empty");
		}

		WebDriverWait waitEditAdd = new WebDriverWait(driver, 70);
		WebElement editAddress = waitEditAdd.until(ExpectedConditions.elementToBeClickable(By.id("address")));
		if(editAddress.isDisplayed()) {
			editAddress.clear();
		}else {
			System.out.println("BUG: Unable to locate/update address");
		}

		//Enter integer on Country textbox and check the search result
		WebElement editCountry = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("s2id_country")));
		editCountry.click();
		WebElement enterCountry = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/input")));
		enterCountry.sendKeys(KaligoConstants.invalidCountry);
		enterCountry.sendKeys(Keys.ENTER); 
		WebElement waitSrchRslt = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[14]/ul/li")));
		String waitSrchRsltVeri = waitSrchRslt.getText();
		if(waitSrchRsltVeri.equals(KaligoConstants.noSearchResult)) {
			System.out.println("The search result message is correct when invalid country is entered");
		} else {
			System.out.println("BUG: The search result message is incorrect when invalid country is entered");
		}
		
		//click company details and click cancel
		WebElement deleteInvalidCountry = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/input")));
		deleteInvalidCountry.sendKeys(Keys.ESCAPE);
		WebDriverWait waitCancelBtn = new WebDriverWait(driver, 50);
		WebElement cancelBtn = waitCancelBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[1]/button[2]")));
		cancelBtn.click();
		
		//Check the Address if it was cleared
		WebElement addressValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[7]/div")));
		String addressValueVerificationViewMode = addressValueViewMode.getText();
		if(addressValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedAddress+UpdateProfile.uuid)) {
			System.out.println("The displayed Address in the Profile Page(view mode) is correct, it was not deleted");
		} else {
			System.out.println("BUG: The displayed Address in the Profile Page(view mode) is incorrect, it was deleted");
		} 
		
		//Check the First Name if it was cleared 
		WebElement firstNameValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[3]/div")));
		String firstNameValueVerificationViewMode = firstNameValueViewMode.getText();
		if(firstNameValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedFirstName+UpdateProfile.uuid)) {
			System.out.println("The displayed First Name in the Profile Page(view mode) is correct, it was not deleted");
		} else {
			System.out.println("BUG: The first name is changed which is incorrect.");
		}
		
		//Check Country if it was changed
		WebElement countryValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[10]/div")));
		String countryValueVerificationViewMode = countryValueViewMode.getText();
		if(countryValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedCountry)) {
			System.out.println("The displayed Country in the Profile is "+KaligoConstants.updatedCountry+" is correct, it was not changed");
		} else {
			System.out.println("BUG: The Country is incorrect" +  countryValueVerificationViewMode + countryValueViewMode);
		}
	}
}
