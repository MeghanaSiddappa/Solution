package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends WebDriverUtility{
	//Declaration
		@FindBy(id="email")
		private WebElement emailTxtBox;
		@FindBy(id="pass")
		private WebElement passwordTxtBox;
		@FindBy(xpath="//button[text()='Log in']")
		private WebElement loginBtn;
		@FindBy(xpath="//a[text()='Create new account']")
		private WebElement creatAccountBtn;
		@FindBy(xpath="//a[text()='Forgotten password?']")
		private WebElement forgotLink;
		
		//Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//utilization
		public WebElement getEmailTxtBox() {
			return emailTxtBox;
		}
		public WebElement getPasswordTxtBox() {
			return passwordTxtBox;
		}
		public WebElement getLoginBtn() {
			return loginBtn;
		}
		public WebElement getCreatAccountBtn() {
			return creatAccountBtn;
		}
		public WebElement getForgotLink() {
			return forgotLink;
		}

		//business library
		public void verifyVisibilityOfElements()
		{
			Assert.assertTrue(getPasswordTxtBox().isDisplayed(), "Password Text Field is displayed");
			Assert.assertTrue(getEmailTxtBox().isDisplayed(), "Email Text Field is displayed");
			Assert.assertTrue(getLoginBtn().isDisplayed(), "Login Button is displayed");
			Assert.assertTrue(getCreatAccountBtn().isDisplayed(), "Create Account Button is displayed");
			Assert.assertTrue(getForgotLink().isDisplayed(), "Forget Password Link is displayed");
			
		}
}
