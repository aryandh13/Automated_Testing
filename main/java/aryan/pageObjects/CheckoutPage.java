package aryan.pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aryan.abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".action__submit")
	 private WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	private By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
		
		
	}

	
	
	

}
