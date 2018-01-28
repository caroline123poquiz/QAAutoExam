package com.kaligo.test;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaligo.test.constants.KaligoConstants;

public class UpdateProfile {
	public static final String uuid = UUID.randomUUID().toString();

	public void processUpdateAccount(WebDriver driver) {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 50);
		//Find the "Edit Profile" button and click it
		WebElement editProfile = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[1]/button")));
		if(editProfile.isDisplayed()) {
			editProfile.click();
			System.out.println("Edit profile button is displayed and is successfully clicked");
		}else {
			System.out.println("BUG: Unable to locate Edit Profile");
		}

		//Find and modify Title
		WebElement editTitle = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("title")));
		Select ddlTitle = new Select (driver.findElement(By.id("title")));
		if(editTitle.isDisplayed()) {
			ddlTitle.selectByVisibleText(KaligoConstants.updatedTitle);
			System.out.println("Title is located");
		}else {
			System.out.println("BUG: Unable locate/select Title");
		}

		//Modify FirstName
		WebElement editFirstName = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
		if(editFirstName.isDisplayed()) {
			editFirstName.clear();
			editFirstName.sendKeys(KaligoConstants.updatedFirstName+uuid);
			System.out.println("First Name is located");
		}else {
			System.out.println("BUG: Unable to locate/update first name");
		}

		//Find and modify LastName
		WebElement editLastName = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("last-name")));
		if(editLastName.isDisplayed()) {
			editLastName.clear();
			editLastName.sendKeys(KaligoConstants.updatedLastName+uuid);
			System.out.println("Last Name is located");
		}else {
			System.out.println("BUG: Unable to locate/update last name");
		}

		//Find and modify day of birth
		WebElement editDayOfBirth = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("dob-day")));
		Select ddlDayOfBirth = new Select (driver.findElement(By.id("dob-day")));
		if(editDayOfBirth.isDisplayed()) {
			ddlDayOfBirth.selectByVisibleText(KaligoConstants.dayOfBirth);
			System.out.println("Day of Birth is located");
		}else {
			System.out.println("BUG: Unable locate/select day of birth");
		}

		//Find and modify month of birth
		WebElement editMonthOfBirth = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("dob-month")));
		Select ddlMonthOfBirth = new Select (driver.findElement(By.id("dob-month")));
		if(editMonthOfBirth.isDisplayed()) {
			ddlMonthOfBirth.selectByVisibleText(KaligoConstants.monthOfBirth);
			System.out.println("Month of Birth is displayed");
		}else {
			System.out.println("BUG: Unable to locate/select Month of Birth");
		}

		//Find and modify year of birth
		WebElement editYearOfBirth = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("dob-year")));
		Select ddlYearOfBirth = new Select (driver.findElement(By.id("dob-year")));
		if(editYearOfBirth.isDisplayed()) {
			ddlYearOfBirth.selectByVisibleText(KaligoConstants.yearOfBirth);
			System.out.println("Year of Birth is displayed");
		}else {
			System.out.println("BUG: Unable to locate/select Month of Birth");
		}

		//Verify that the email address textbox is disabled
		boolean emailAddressTextboxDisabled = driver.findElement(By.id("address")).isDisplayed();
		if(emailAddressTextboxDisabled==true) {
			System.out.println("Email Address is disabled and grayed out.");
		}else {
			System.out.println("BUG: Please check. Email Address is enabled");
		}

		//Find and modify Address
		WebElement editAddress = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("address")));
		if(editAddress.isDisplayed()) {
			editAddress.clear();
			editAddress.sendKeys(KaligoConstants.updatedAddress+uuid);
			System.out.println("Address is displayed");
		}else {
			System.out.println("BUG: Unable to locate/update address");
		}

		//Find and modify City
		WebElement editCity = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("city")));
		if(editCity.isDisplayed()) {
			editCity.clear();
			editCity.sendKeys(KaligoConstants.updatedCity+uuid);
			System.out.println("City is displayed");
		}else {
			System.out.println("BUG:Unable to locate/update city");
		}

		//Find and modify Zip/Post Code
		WebElement editZipCode = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("zip")));
		if(editZipCode.isDisplayed()) {
			editZipCode.clear();
			editZipCode.sendKeys(KaligoConstants.updatedZipCode+uuid);
			System.out.println("ZipCode is displayed");
		}else {
			System.out.println("BUG:Unable to locate/update Zip Code");
		}

		//Find and modify Country
		WebElement editCountry = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("s2id_country")));
		if(editCountry.isDisplayed()) {
			editCountry.click();
			WebElement enterCountry = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[14]/div/input")));
			enterCountry.sendKeys("Singapore");
			enterCountry.sendKeys(Keys.ENTER);
			System.out.println("Country is displayed");
		}else {
			System.out.println("BUG: Unable to locate/update Country");
		}

		//Find and modify Company
		WebElement editCompany = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("company")));
		if(editCompany.isDisplayed()) {
			editCompany.clear();
			editCompany.sendKeys(KaligoConstants.updatedCompany+uuid);
			System.out.println("Company is displayed");
		}else {
			System.out.println("BUG: Unable to locate/update company");
		}

		//Find and modify Company Details
		WebElement editCompanyDetails = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[13]/div/input")));
		if(editCompanyDetails.isDisplayed()) {
			editCompanyDetails.clear();
			editCompanyDetails.sendKeys(KaligoConstants.updatedCompanyDetails+uuid);
			System.out.println("CompanyDetails is displayed");
		}else {
			System.out.println("BUG: Unable to locate/update Company Details");
		}

		//Locate Save Changes and click it
		WebElement saveChange = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[14]/button[1]")));
		if(saveChange.isDisplayed()) {
			System.out.println("The Save Changes button is displayed in the Profile page (Edit mode)");
			saveChange.click();
		}else {
			System.out.println("BUG: Unable to locate Save Change button");
		}

		//Check that the successful message is displayed after clicking the save change button
		WebElement successfulMessage = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div/div[1]/span")));
		String successfulMessageVerification = successfulMessage.getText();
		if(successfulMessageVerification.equals("Your profile has been updated.")) {
			System.out.println("Successful message is displayed");
		} else {
			System.out.println("BUG: Successful message is incorrect");
		}	

		//Check header name in the profile page after saving the changes
		WebElement headerValue = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/div[2]")));
		String headerValueVerification = headerValue.getText();
		if(headerValueVerification.equalsIgnoreCase("Hello, " + KaligoConstants.updatedFirstName+uuid)) {
			System.out.println("Header Name is correct in Profile Page (view mode)");
		} else {
			System.out.println("BUG: Header Name is incorrect" + headerValueVerification + headerValue);
		}	

		//Check title in the profile page after saving the changes
		WebElement titleValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[2]/div")));
		String titleValueVerificationViewMode = titleValueViewMode.getText();
		if(titleValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedTitle)) {
			System.out.println("The Displayed title in Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The Displayed title in Profile Page(view mode) is incorrect");
		}	

		//Check First Name in the profile page after saving the changes
		WebElement firstNameValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[3]/div")));
		String firstNameValueVerificationViewMode = firstNameValueViewMode.getText();
		if(firstNameValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedFirstName+uuid)) {
			System.out.println("The displayed First Name in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed First Name in the Profile Page(view mode) is incorrect");
		}	

		//Check Last Name in the profile page after saving the changes
		WebElement lastNameValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[4]/div")));
		String lastNameValueVerificationViewMode = lastNameValueViewMode.getText();
		if(lastNameValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedLastName+uuid)) {
			System.out.println("The displayed Last Name in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Last Name in the Profile Page(view mode) is incorrect");
		} 

		//Check Birthday in the profile page after saving the changes
		WebElement birthdayValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[5]/div")));
		String birthdayValueVerificationViewMode = birthdayValueViewMode.getText();
		if(birthdayValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.birthday)) {
			System.out.println("The displayed Birthday in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Birthday in the Profile Page(view mode) is incorrect");
		} 

		//Check Email Address in the profile page after saving the changes
		WebElement emailAddressValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[6]/div")));
		String emailAddressValueVerificationViewMode = emailAddressValueViewMode.getText();
		if(emailAddressValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.emailAdd)) {
			System.out.println("The displayed Email Address in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Email Address in the Profile Page(view mode) is incorrect");
		} 

		//Check Address in the profile page after saving the changes
		WebElement addressValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[7]/div")));
		String addressValueVerificationViewMode = addressValueViewMode.getText();
		if(addressValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedAddress+uuid)) {
			System.out.println("The displayed Address in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Address in the Profile Page(view mode) is incorrect");
		} 

		//Check City in the profile page after saving the changes
		WebElement cityValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[8]/div")));
		String cityValueVerificationViewMode = cityValueViewMode.getText();
		if(cityValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedCity+uuid)) {
			System.out.println("The displayed City in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed City in the Profile Page(view mode) is incorrect");
		} 

		//Check Zip Code in the profile page after saving the changes
		WebElement zipCodeValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[9]/div")));
		String zipCodeValueVerificationViewMode = zipCodeValueViewMode.getText();
		if(zipCodeValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedZipCode+uuid)) {
			System.out.println("The displayed Zip Code in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Zip Code in the Profile Page(view mode) is incorrect");
		} 

		//Check Country in the profile page after saving the changes
		WebElement countryValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[10]/div")));
		String countryValueVerificationViewMode = countryValueViewMode.getText();
		if(countryValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedCountry)) {
			System.out.println("The displayed Country in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Country in the Profile Page(view mode) is incorrect");
		} 

		//Check Company in the profile page after saving the changes
		WebElement companyValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[12]/div")));
		String companyValueVerificationViewMode = companyValueViewMode.getText();
		if(companyValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedCompany+uuid)) {
			System.out.println("The displayed Company in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Company in the Profile Page(view mode) is incorrect");
		} 

		//Check Company Details in the profile page after saving the changes
		WebElement companyDetailsValueViewMode = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/form[1]/div[13]/div")));
		String companyDetailsValueVerificationViewMode = companyDetailsValueViewMode.getText();
		if(companyDetailsValueVerificationViewMode.equalsIgnoreCase(KaligoConstants.updatedCompanyDetails+uuid)) {
			System.out.println("The displayed Company Details in the Profile Page(view mode) is correct");
		} else {
			System.out.println("BUG: The displayed Company Details in the Profile Page(view mode) is incorrect");
		} 

		//Logout user
		WebElement logoutUser = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[1]")));
		if(logoutUser.isDisplayed()) {
			logoutUser.click();
			System.out.println("User is successfully logged out");
		}else {
			System.out.println("BUG:Unable to locate/log out user");
		}

		WebDriverWait waitConfirmSpin = new WebDriverWait(driver, 150);
		waitConfirmSpin.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-gif")));
		WebDriverWait waitConfirmLoginLink = new WebDriverWait(driver, 90);		
		WebElement loginlink = waitConfirmLoginLink.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div/nav/div[2]/div")));
		loginlink.click();
	}

}
