package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drevers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.findElement(By.xpath("//td[contains(text(),'Full Name')]/..//input")).sendKeys("Prarthna");

		driver.findElement(By.xpath("//td[contains(text(),'Choose a Rediffmail ID')]/..//input[@type='text']"))
				.sendKeys("prarthna28");

		driver.findElement(By.className("btn_checkavail")).click();
		driver.findElement(By.xpath("//td[contains(text(),'Password')]/..//input")).sendKeys("Pra@93");
		driver.findElement(By.xpath("//td[contains(text(),'Retype password')]/..//input")).sendKeys("Pra@93");
		driver.findElement(By.xpath("//td[contains(text(),'Alternate Email Address')]/..//input")).sendKeys("pra#28");
		boolean b = driver.findElement(By.id("Register")).isDisplayed();
		if (b) {
			System.out.println("Buttion is displayed");
		}
		Select s = new Select(driver.findElement(By.cssSelector("select[name^=\"DOB_Day\"]")));
		s.selectByValue("01");

		Select s1 = new Select(driver.findElement(By.cssSelector("select[name^=\"DOB_Montha\"]")));
		s1.selectByValue("01");

		Select s2 = new Select(driver.findElement(By.cssSelector("select[name^=\"DOB_Year\"]")));
		s2.selectByValue("2018");

	}

}
