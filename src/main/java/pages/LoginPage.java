package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//emailField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
	}

	public AccountPage ClickOnLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//return warningMessage.getText();	
		}
}
