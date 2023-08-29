package guruProjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5 {
	String firstname="JANARDHAN";
	String lastName="MUDDADA";
	String middleName="RAO";	  
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
	  //2. click on my account link
	  driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("My Account")).click();
	  //3.click on Create Account and Fill new user information  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/a")).click();
	  
	  
	  driver.findElement(By.id("firstname")).sendKeys(firstname);
	  
	  driver.findElement(By.id("middlename")).sendKeys(middleName);
	  
	  driver.findElement(By.id("lastname")).sendKeys(lastName);
	  
	  driver.findElement(By.id("email_address")).sendKeys("pubgian002@gmail.com");
	  
	  driver.findElement(By.id("password")).sendKeys("Janardhan890");
	  
	  driver.findElement(By.id("confirmation")).sendKeys("Janardhan890");
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[4]/label")).click();
	  //4.click on register
	  driver.findElement(By.cssSelector("button.button:nth-child(2)")).click();
	  //switching to window
	  for(String handle:driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  //5.verify register is done
	  String expectedValue="WELCOME,"+" "+firstname+" "+middleName+" "+lastName+"!";
	  String actualValue=driver.findElement(By.cssSelector("p.welcome-msg")).getText();
	  assertEquals(actualValue, expectedValue);
	  //6.Go to TV menu
	  driver.findElement(By.linkText("TV")).click();
	  //7.Add product in you wish list 
	  driver.findElement(By.linkText("Add to Wishlist")).click();
	  //8.Share wish list
	  driver.findElement(By.cssSelector(".btn-share")).click();
//	  //9.In next page Enter email address and message and click on shareWish List
	  driver.findElement(By.cssSelector("textarea#email_address")).sendKeys("jana18fe1a090@gmail.com");
	  driver.findElement(By.cssSelector("textarea#message")).sendKeys("Please see once about this product");
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button")).click();
	  //10.Verifying wishList is shared or not
	  String wishList="Your Wishlist has been shared.";
	  String actualwishList=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	  assertEquals(actualwishList, wishList);
  }
  @AfterTest
  public void tearDown() {
//	  driver.quit();
  }
  
}
