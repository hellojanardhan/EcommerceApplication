package guruProjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6 {
	public String firstName = "BERRY";    
	public String lastName = "BERRYSEVEN";  
	public String vEmail = "Berry.Berrysix@tpg.com.au";
	public String vPW = "123456";
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	@Test
	public void launchBrowser() throws InterruptedException {
		//1.Go to http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		//2.click on my account link
		driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a")).click();
		driver.findElement(By.linkText("My Account")).click();
		//3.Login in application using previously created Account
		driver.findElement(By.id("email")).sendKeys("pubgian002@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Janardhan890");
		driver.findElement(By.id("send2")).click();
		//4.click on my whishList link
		driver.findElement(By.linkText("MY WISHLIST")).click();
		//Go to TV menu
		driver.findElement(By.linkText("TV")).click();
		//Add product in you wish list 
		driver.findElement(By.linkText("Add to Wishlist")).click();
		//5.In next page,click add to cart
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		//6.click on proceed to checkout
		driver.findElement(By.cssSelector(".top > li:nth-child(1) > button:nth-child(1)")).click();
		//7.Enter shipping information
		driver.findElement(By.id("billing:firstname")).clear();
		driver.findElement(By.id("billing:middlename")).clear();
		driver.findElement(By.id("billing:lastname")).clear();
		driver.findElement(By.id("billing:street1")).clear();
		driver.findElement(By.id("billing:city")).clear();
		driver.findElement(By.id("billing:postcode")).clear();
		driver.findElement(By.id("billing:telephone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("billing:firstname")).sendKeys("janardhan");
		driver.findElement(By.id("billing:middlename")).sendKeys("Rao");
		driver.findElement(By.id("billing:lastname")).sendKeys("Jhon");
		driver.findElement(By.id("billing:street1")).sendKeys("New York");
		driver.findElement(By.id("billing:city")).sendKeys("New York");
		Select city=new Select(driver.findElement(By.id("billing:country_id")));
		city.selectByVisibleText("United States");
		driver.findElement(By.id("billing:region_id")).sendKeys("New York");
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");
		driver.findElement(By.id("billing:telephone")).sendKeys("1234567890");
		driver.findElement(By.id("billing:use_for_shipping_yes")).click();
		//8.Click continue
		driver.findElement(By.cssSelector("#billing-buttons-container > button:nth-child(1)")).click();
		//switching to new window
		for(String handles:driver.getWindowHandles()) {
			driver.switchTo().window(handles);
		}
		//9.verify shipping cost generated
//		String sFlatRate = "Flat Rate";
//	    String flatRate = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dt")).getText();	
//	    try {
//	    	System.out.println("sFlatRate = "+sFlatRate);
//	    	System.out.println("flatRate = "+flatRate);
//	    	assertEquals(sFlatRate, flatRate);
//		    } catch (Exception e) {
//		    	e.printStackTrace();	    	
//		    }	
//	    	    
//	    String sFlatRatePrice = "Fixed - $5.00";
//	    String flatRatePrice = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dd/ul/li/label")).getText();
//	    try {	 
//	    	System.out.println("sFlatRatePrice = "+sFlatRatePrice);
//	    	System.out.println("flatRatePrice = "+flatRatePrice);
//	    	assertEquals(sFlatRatePrice, flatRatePrice);
//		    } catch (Exception e) {
//		    	e.printStackTrace();	    	
//		    }	
		//10.select shipping cost,update total
		driver.findElement(By.id("s_method_flatrate_flatrate")).click();
	    driver.findElement(By.xpath("//button[@title='Update Total']")).click();
	    //11.verify shipping cost is added to total
	    String vFlatRatePrice = "$5.00";
	    String shippingCostIncluded = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	    
	    assertEquals(vFlatRatePrice, shippingCostIncluded);
	    //12.click on proceed to check out
	    driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
	    for(String handles:driver.getWindowHandles()) {
			driver.switchTo().window(handles);
		}
	    //13.Enter billing information
	    Select bAddr = new Select(driver.findElement(By.name("billing_address_id")));
    	int bAddrSize = bAddr.getOptions().size();
    	bAddr.selectByIndex(bAddrSize-1); 
    	driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).sendKeys(firstName); 
	    driver.findElement(By.id("billing:lastname")).clear();
	    driver.findElement(By.id("billing:lastname")).sendKeys(lastName); 
	    driver.findElement(By.id("billing:company")).clear(); 
	    
	    driver.findElement(By.id("billing:street1")).clear();
	    driver.findElement(By.id("billing:street1")).sendKeys("148 Crown Street"); 
	    new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']"))).selectByIndex(14);
	    Thread.sleep(5000);	    
	    driver.findElement(By.id("billing:city")).clear();	
	    driver.findElement(By.id("billing:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("billing:region")).clear();
	    driver.findElement(By.id("billing:region")).sendKeys("New South Wales");
	    driver.findElement(By.id("billing:postcode")).clear();
	    driver.findElement(By.id("billing:postcode")).sendKeys("2000");
	    driver.findElement(By.id("billing:telephone")).clear();
	    driver.findElement(By.id("billing:telephone")).sendKeys("8850 6789"); 
	    //shipping to different address
	    driver.findElement(By.id("billing:use_for_shipping_no")).click();
	    //click on continue button
	    driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    //Shipping Address
	    try {
	    	Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
	    	int sAddrSize = sAddr.getOptions().size();
	    	sAddr.selectByIndex(sAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
	    
	  
	    Thread.sleep(3000);  
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).sendKeys(firstName); 
	    driver.findElement(By.id("shipping:lastname")).clear();
	    driver.findElement(By.id("shipping:lastname")).sendKeys(lastName); 
	    driver.findElement(By.id("shipping:company")).clear(); 
	    
	    driver.findElement(By.id("shipping:street1")).clear();
	    driver.findElement(By.id("shipping:street1")).sendKeys("50 Berry Street"); 
	    driver.findElement(By.id("shipping:street2")).clear();
	    // shipping country must be selected first from dropdown
	    new Select(driver.findElement(By.xpath("//select[@id='shipping:country_id']"))).selectByIndex(14); 
	    // once Australia is selected, then the region and city becomes simply a text input, instead of dropdown
	    driver.findElement(By.id("shipping:region")).clear();
	    driver.findElement(By.id("shipping:region")).sendKeys("New Sounth Wales"); 
	    driver.findElement(By.id("shipping:city")).clear();
	    driver.findElement(By.id("shipping:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("shipping:postcode")).clear();
	    driver.findElement(By.id("shipping:postcode")).sendKeys("2000"); 
	    driver.findElement(By.id("shipping:telephone")).clear();
	    driver.findElement(By.id("shipping:telephone")).sendKeys("8034 1234");
	        
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button")).click(); 
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    //14.In shipping method,click continue;
	    driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click(); 	
	   	 
	    Thread.sleep(2000);
	    //15.In Payment Information select 'Check/Money Order' radio button. Click Continue
	    driver.findElement(By.xpath("//input[@title='Check / Money order']")).click();
	    
	    Thread.sleep(3000);	    
	    
	    driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click(); 
	     
	    Thread.sleep(3000);
	    //16.Click 'PLACE ORDER' button  
	    driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click(); 
	    
	    Thread.sleep(3000);
	    //17.Verify Oder is generated. Note the order number 
	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	    System.out.println("*** Your order number for your record = " + orderNum);   
	}
	
	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
}
