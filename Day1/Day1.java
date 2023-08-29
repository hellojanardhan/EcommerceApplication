package guruProjects;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1 {
	WebDriver driver;
  @BeforeTest
  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  
  }
  @Test
  public void launchBrowser() throws IOException {
	  	//1.Go to http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		
		//2.Verify title of the page
		try {
			Assert.assertEquals(driver.getTitle(),"Home page");
		} catch (Exception e) {
			System.out.println(e);
		}
		//3.click on Mobile menu
		driver.findElement(By.linkText("MOBILE")).click();
		//4.Verify title of the page
		Assert.assertEquals(driver.getTitle(), "Mobile");
		//5.In list of all mobile,select Sort by drop down as name  
		Select select=new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		select.selectByVisibleText("Name");
		//6.Verify all the products sort by name
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Janardhan\\OneDrive\\Pictures\\Screenshots\\sorted.jpg"));
		
  }
  @AfterTest
  public void tearDown() {
//	  driver.quit();
  }
}
