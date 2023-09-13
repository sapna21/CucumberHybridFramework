package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {    //constructor
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	@FindBy(xpath ="//span[text()='My Account']")
	private WebElement myAccountDroupMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registeOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath ="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDroupMenu, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(registeOption, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//registeOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String validProductText) {
		
		elementUtils.typeTextIntoElement(searchBoxField, validProductText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//searchBoxField.sendKeys(validProductText);
	}
	
	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		//searchButton.click();
		return new SearchResultPage(driver);
	}
}
