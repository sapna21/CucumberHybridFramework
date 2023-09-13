package Stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;


public class Register_Stepdefination {
	
	WebDriver driver;
    private	RegisterPage registerpage;
    private AccountSuccessPage accountSuccessPage;
    private CommonUtils commonUtils;
    
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);//object creation
		
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable datatable) {
		
		Map<String, String> dataMap = datatable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerpage.enterEmailAddress(commonUtils.getEmailTimeStamp());
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		//driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable datatable) {
		
    Map<String, String> dataMap = datatable.asMap(String.class,String.class);
    
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("password"));
		
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		//driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		
	
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerpage.selectPrivacypolicy();
		//driver.findElement(By.name("agree")).click();
		
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		//Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	    
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerpage.selectYesNewsLetterOption();
		//driver.findElement(By.name("newsletter")).click();
	    
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	    
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
		
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
	
		//Intentionally kept blank
		
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmailAddress("");
		registerpage.enterTelephoneNumber("");
		registerpage.enterPassword("");
		registerpage.enterConfirmPassword("");
	    
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarning() );
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning() );
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());
		
		
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		//Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
		//Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		//Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		//Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		//Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
		
	}
	
	

}