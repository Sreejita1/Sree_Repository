package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class PopupTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@href = \"dashboard\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("googleLoginButton")).click();
	  String winHandleBefore = driver.getWindowHandle();
	  for(String winHandle : driver.getWindowHandles())
	  {
		  driver.switchTo().window(winHandle);
		  System.out.println("Window Switch");
		  System.out.println(driver.getTitle());
		  if(driver.getTitle().contains("Sign in"));
		  {
			  driver.findElement(By.className("oY86ze")).click();
		  }
		  driver.close();
	  }
	  driver.switchTo().window(winHandleBefore);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drevers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.rentedroofs.com/");

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
