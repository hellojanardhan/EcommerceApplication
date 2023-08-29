package guruProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2 {
	WebDriver driver;
  @SuppressWarnings("deprecation")
@BeforeTest
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test
  public void launchBrowser() throws InterruptedException {
	  //1.Go to http://live.techpanda.org/
	  driver.get("http://live.techpanda.org/");
	  //2.Click on Mobile Menu
	  driver.findElement(By.linkText("MOBILE")).click();
	  //3.In list of all mobile,read the cost of SONY XPeria mobile and note this value.
	  String cost=driver.findElement(By.cssSelector("#product-price-1 > span:nth-child(1)")).getText();
	  System.out.println(cost);
	  //4.click on SONY XPeria mobile
	  driver.findElement(By.id("product-collection-image-1")).click();
	  //5.Read the SONY XPeria mobile from detail page
	  String cost1=driver.findElement(By.cssSelector(".price")).getText();
	  //6.compare value in step 3 and step 5
	  Assert.assertEquals(cost1, cost);
	  
  }
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
