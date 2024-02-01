package Task2;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.LoginPage;

public class Scenario1 extends BaseClass{

@Test()
public void validateElements () {

	LoginPage loginPage = new LoginPage(driver);
	loginPage.verifyVisibilityOfElements();
}
}