package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastnameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		
		elementUtils.typeTextIntoElement(lastnameField, lastNameText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//lastnameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPasswordText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void selectPrivacypolicy() {
		
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//privacyPolicyOption.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption() {
		
		elementUtils.clickOnElement(yesNewsLetterOption, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//yesNewsLetterOption.click();
	}
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return warningMessage.getText();
	}
	
	public String getFirstNameWarning() {
		
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return firstNameWarning.getText();
	}

	public String getLastNameWarning() {
		
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return lastNameWarning.getText();
	}
	public String getEmailWarning() {
		
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return emailWarning.getText();
	}
	public String getTelephoneWarning() {
		
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return passwordWarning.getText();
	}
}
