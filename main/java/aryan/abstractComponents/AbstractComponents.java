package aryan.abstractComponents;

import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import aryan.pageObjects.CartPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	public CartPage goToCart() 
	{
		cartBtn.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
		
	}
	
	public void waitForAppear(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	} 
	
	public void waitForDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	} 
	
	
	
	
}
