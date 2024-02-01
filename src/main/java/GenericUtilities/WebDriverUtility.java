package GenericUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	/**
	 * this method is used to launch the browser
	 * @param driver
	 * @param browser
	 */
	public WebDriver launchBrowser(WebDriver driver, String browser){
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\workspace\\Cognizant\\Softwares\\chromedriver.exe");


			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//ChromeDriver driver = new ChromeDriver(options)
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			return driver;
		}
		else if (browser.equalsIgnoreCase("firefox")) {

			//System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			return driver;
		}
		else if (browser.equalsIgnoreCase("ie")) {

			//System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			return driver;
		}
		else {
			System.out.println("Invalid browser");
			return driver;
		}
	}


	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver){
		driver.manage().window().maximize();
	}
	/**
	 * This method will wait for 20 seconds for page to get loaded
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait for 10 seconds for an element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will capture screenshot and store it in specified folder
	 *  @param driver
	 *   @param screenShotName
	 *   @return
	 *   @throws Throwable
	 */
	public String getScreenShot(WebDriver driver, String screenShotName) throws Throwable{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
	
		FileUtils.copyFile(src, dst);
		String absolutePath = dst.getAbsolutePath();
		return absolutePath;

	}

	
}
