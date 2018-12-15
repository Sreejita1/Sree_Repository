package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drevers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		WebElement e = driver.findElement(By.id("searchInput"));
		e.clear();
		e.sendKeys("India");
		e.click();
		driver.findElement(By.id("searchButton")).click();
		driver.quit();
		

	}

}
