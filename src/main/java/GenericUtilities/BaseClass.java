package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseClass {

	WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver=null;

	@BeforeClass()
	public void launchBrowser() throws Throwable
	{
		String BROWSER = IPathConstants.Browser;
		driver = wLib.launchBrowser(driver, BROWSER);
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		System.out.println(BROWSER+" browser launched successfully");
	}
	@BeforeMethod()
	public void login() throws Throwable
	{
		String URL= IPathConstants.URL;
		driver.get(URL);
	}
	@AfterClass()
	public void closeBrowser()
	{
		driver.quit();
		System.out.println(" Browser closed successfully");
	}
}
