package aryan;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aryan.pageObjects.LandingPage;
import aryan.pageObjects.ProductCatalogue;
import aryan.testComponents.BaseTest;
import aryan.pageObjects.CartPage;
import aryan.pageObjects.CheckoutPage;
import aryan.pageObjects.ConfirmationPage;



public class Test1 extends BaseTest{
	
	@Test
	public void Test() throws InterruptedException
	{
		//WebDriverManager.chromedriver.setup();
		
		
		
		//String p="Zara Coat-3";
		
		
		ProductCatalogue prodCatalogue=landingPage.loginApplication("aryandhaor13@gmail.com", "aryanD2001#");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//driver.findElement(By.cssSelector("input[id='login']")).click(); 
		
		
		List<WebElement> prodName= prodCatalogue.getProducts();

		WebElement prod=prodCatalogue.getProductByName("ZARA COAT 3");
		
		prodCatalogue.waitForAppear(By.cssSelector(".mb-3"));
		
		prodCatalogue.addToCart();
		
		CartPage cartPage=prodCatalogue.goToCart();
		
		Boolean val=cartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(val);
		Thread.sleep(2000);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		
		checkoutPage.selectCountry("india");
		
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		
		Boolean b=confirmationPage.confirm().equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(b);
		
		//Thread.sleep(3000);
		
		
		
		
		
		
	}

}
