package aryan.testComponents;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aryan.pageObjects.LandingPage;
import aryan.pageObjects.ProductCatalogue;
import aryan.pageObjects.CartPage;
import aryan.pageObjects.CheckoutPage;
import aryan.pageObjects.ConfirmationPage;

public class BaseTest {
	
	
	WebDriver driver;
	public LandingPage landingPage=new LandingPage(driver);

	public WebDriver Initialize()
	{
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage LaunchApplication()
	{
		driver=Initialize();
		landingPage.goTo("https://rahulshettyacademy.com/client");
		return landingPage;
	}

	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
