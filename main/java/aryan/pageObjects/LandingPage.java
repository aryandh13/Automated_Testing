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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aryan.abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmail=driver.findElement(By.cssSelector("input[type='email']"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email, String psw)
	{
		userEmail.sendKeys(email);
		password.sendKeys(psw);
		submit.click();
		ProductCatalogue prodCatalogue=new ProductCatalogue(driver);
		return prodCatalogue;
	}
	
	public void goTo(String url)
	{
		driver.get(url);
	}
	
	
	
	

			
	
	
	

}
