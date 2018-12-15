package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class TestAutoit {
	@Test
	public void testCaseOne_Test_One() throws IOException, InterruptedException {
		driver.findElement(By.name("img")).click();
		Runtime.getRuntime().exec("E:\\Prarthna\\FileUpload.exe");
	}

	WebDriver driver;

	@BeforeTest

	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drevers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
	}

	//@AfterTest
  public void afterTest() {
	  driver.quit();
	}
}
