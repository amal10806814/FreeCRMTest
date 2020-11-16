package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testUtil.TestDataClass;
import testUtil.TestUtilTimeout;
import testUtil.WebEventListener;

public class ExcelReadTest extends TestDataClass{
	
	WebDriver driver;

	String filePathnew = "/Users/Chaudhary/Documents/GIT_Projects/FreeCRMTest/src/main/java/TestData/FreeCRMTestData.xlsx";
	String name = "Contacts";
	
	   @BeforeMethod
	   public void openBrowser()
	   {
	            System.setProperty("webdriver.chrome.driver" , "/Users/Chaudhary/Documents/Drivers/chromedriver");
	            driver = new ChromeDriver();

	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(TestUtilTimeout.Page_Timeout , TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(TestUtilTimeout.Implicit_Timeout , TimeUnit.SECONDS);

	        driver.get("https://www.facebook.com/");
	        
	   }

	
	@DataProvider
	public String[][] readData() throws IOException
	{
		String[][] data =TestDataClass.getDataFromExcel(filePathnew,name );
		return data;
	}
	
	@Test(dataProvider = "readData")
	public void loginTest(String username, String password)
	{
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
