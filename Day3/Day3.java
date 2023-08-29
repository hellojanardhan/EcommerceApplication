package guruProjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3 {
	WebDriver driver;
  @BeforeTest
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
  }
  @Test
  public void launchBrowser() {
	  //1.Go to http://live.techpanda.org/
	  driver.get("http://live.techpanda.org/");
	  //2.click on Mobile Menu
	  driver.findElement(By.linkText("MOBILE")).click();
	  //3.In list of mobile, Click on Add to cart For SONY XPeria mobile
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click();
	  //4.change QTY value to 1000 and click on update button
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).sendKeys("1000");
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();
	  //5.Verify the error message	  
	  String actualError=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[2]/p")).getText();
	  String expectedError="* The maximum quantity allowed for purchase is 500.";
	  assertEquals(actualError, expectedError);
	  //6.Then click on Empty Cart link in the footer of the list of all mobile.
	  driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]")).click();
	  //7.verify cart is empty
	  String cartError=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/p[1]")).getText();
	  String exError="You have no items in your shopping cart.";
	  assertEquals(cartError, exError);
  }
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
  
}
