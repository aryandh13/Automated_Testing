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
import org.openqa.selenium.support.PageFactory;

import aryan.abstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By prodBy=By.cssSelector(".mb-3");
	
	public List<WebElement> getProducts()
	{
		waitForAppear(prodBy);
		return products;
	}
	
	WebElement prod;
	
	public WebElement getProductByName(String name)
	{
		prod= products.stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart()
	{
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForAppear(By.cssSelector("#toast-container"));
		waitForDisappear(spinner); 
	}
	
	
}
