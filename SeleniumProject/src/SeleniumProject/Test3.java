package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Test3 {
	WebDriver driver;
  @Test
  public void f() {
	 driver.switchTo().frame("packageListFrame");
	 driver.findElement(By.cssSelector("a[href='com/thoughtworks/selenium/package-frame.html']")).click();
  }
  @BeforeTest
  public void beforeTest() {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drevers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
