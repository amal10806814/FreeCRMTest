package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import testUtil.TestUtilTimeout;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactPage;

	public ContactsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homepage.clickContacts();
		driver.manage().timeouts().implicitlyWait(TestUtilTimeout.Implicit_Timeout, TimeUnit.SECONDS);
		
	}
		
	
	@Test(priority =1)
	public void contactLogoTest()
	{
		WebDriverWait wait = new WebDriverWait (driver, 30);
		//wait.until(ExpectedConditions.textToBe(By.xpath("//div//div[contains(text(), 'Contacts')]"), "Contacts"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Contacts')]"))));
		Assert.assertTrue(contactPage.checkContactsLogo());
	}
	
	@Test(priority = 2)
	public void radioBtnTest()
	{
		contactPage.clickRadioButton("gaurav kumar");
	
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
