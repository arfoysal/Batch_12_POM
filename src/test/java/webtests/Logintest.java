package webtests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.DarazHomePage;
import pages.DarazLoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class Logintest extends DriverSetup {
	DarazHomePage darazHomePage = new DarazHomePage();
	DarazLoginPage darazLoginPage = new DarazLoginPage();
	
	@Test(priority = 0, description = "Home Page Loading Test with base URL")
	@Description("Test Description: Load website with base URL and maximize the window")
	public void testHomePageUrl() {
		getDriver().get("https://www.daraz.com.bd/");
		assertEquals(getDriver().getCurrentUrl(), "https://www.daraz.com.bd/");
		darazHomePage.takeScreenShot("HomePage");
	}
	
	@Test
	public void testHomePageTitle() {
		getDriver().get("https://www.daraz.com.bd/");
		assertEquals(getDriver().getTitle(), "Online Shopping in Bangladesh: Order Now from Daraz.com.bd");	
		darazHomePage.takeScreenShot("HomePage1");
	}

	@Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
	public void loginUsingInvalidCredentialsTest(String number, String password, String ErrorTtile, String ErrorMsg) {
		getDriver().get("https://www.daraz.com.bd/");
		darazHomePage.clickONLoginButton();
//		darazLoginPage.enterUsername("01888695");
//		darazLoginPage.enterPassword("Password");
		darazLoginPage.doLogIn(number, password);
		assertEquals(darazLoginPage.getElementText(darazLoginPage.ERROR_TITLE), ErrorTtile);
		assertEquals(darazLoginPage.getElementText(darazLoginPage.ERROR_MESSAGE), ErrorMsg);
		darazLoginPage.takeScreenShot("LoginPage");
	}

}
