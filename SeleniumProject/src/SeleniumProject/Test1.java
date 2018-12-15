package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Test1 {

	WebDriver driver;
	WebDriverWait wait;
	private By frameLocator = By.className("demo-frame");
	private By tags = By.id("tags");

	@Test
	public void f() {
		WebElement frameElement = driver.findElement(frameLocator);
		driver.switchTo().frame(frameElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(tags));
		WebElement textBoxElement = driver.findElement(tags);
		textBoxElement.sendKeys("a");
		selectOptionWithText("Java");

	}

	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOption = driver.findElement(By.id("ui-id-1"));
			wait.until(ExpectedConditions.visibilityOf(autoOption));
			List<WebElement> optionsToSelect = autoOption.findElements(By.tagName("li"));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					System.out.println(textToSelect);
					break;
				}
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drevers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://jqueryui.com/autocomplete/");
		 wait = new WebDriverWait(driver, 5);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
