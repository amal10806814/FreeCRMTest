package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.DealsPage;
import Pages.HomePage;
import Pages.LoginPage;
import testUtil.TestUtilTimeout;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactPage;
	DealsPage dealPage;

	String sheetName = "Contacts";
	
	public DealsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
		homepage =loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		dealPage =homepage.clickDeals();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtilTimeout.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider= "getCRMTestData")
	public void createDealTest(String title, String assignTo, String company)
	{
		dealPage.clickNewBtn();
		dealPage.createDeal(title, assignTo, company);
		dealPage.clickSaveBtn();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
