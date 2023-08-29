package guruProjects;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4 {
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
	  //2.click on Mobile Menu
	  driver.findElement(By.linkText("MOBILE")).click();
	  //3.In mobile products list,Click on add to compare for 2 mobiles
	  String sony1=driver.findElement(By.linkText("SONY XPERIA")).getText();
	  String Iphone1=driver.findElement(By.linkText("IPHONE")).getText();
	  driver.findElement(By.cssSelector(".products-grid > li:nth-child(2) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
	  driver.findElement(By.cssSelector("li.item:nth-child(3) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
	  //4.click on compare button
	  driver.findElement(By.cssSelector("div.block-content:nth-child(2) > div:nth-child(3) > button:nth-child(1)"));
	  //Switching to another window
	  for(String handles:driver.getWindowHandles()) {
		  driver.switchTo().window(handles);
	  }
	  //5.Verify pop up window and check that the products are reflected in it.
	  driver.manage().window().maximize();
	  String sony2=driver.findElement(By.linkText("SONY XPERIA")).getText();
	  String Iphone2=driver.findElement(By.linkText("IPHONE")).getText();
	  assertEquals(sony1, sony2);
	  Thread.sleep(1000);
	  assertEquals(Iphone1, Iphone2);
	  //Close the pop up window
	  driver.quit();
  }
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
