package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class AlertTest {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//input[@value = \"Show Me Alert\"]")).click();
	 Alert a= driver.switchTo().alert();
	 String str = a.getText();
	 System.out.println(str);
	 a.accept();
	 driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();
	 Alert a1 = driver.switchTo().alert();
	 String str1 = a1.getText();
	 System.out.println(str1);
	 a1.dismiss();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drevers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
