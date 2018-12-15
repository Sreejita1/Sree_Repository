package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AssertTest {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void f() {
		By container = By.cssSelector(".demo-container");
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(container));
		WebElement noDateTextElement = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		String textBeforeAjaxCall = noDateTextElement.getText().trim();
		// click on the date
		driver.findElement(By.linkText("1")).click();
		By loader = By.className("raDiv");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		WebElement selectedDatesTextElement = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
		String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
		Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);
		String expectedTextAfterAjax = "Monday, October 01, 2018";
		Assert.assertEquals(textAfterAjaxCall, expectedTextAfterAjax);
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drevers\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drevers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drevers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browswr is not valid");
		}

		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
