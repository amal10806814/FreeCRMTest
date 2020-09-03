package testCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

     LoginPage loginpageObj;
     HomePage homepage;

    public LoginTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginpageObj = new LoginPage();
    }

    @Test(priority = 1)
    public void TitleTest()
    {
       String title=  loginpageObj.validateTitle();
        Assert.assertEquals(title , "Cogmento CRM");
    }

    @Test(priority = 2)
    public void LoginTest() throws IOException {
       homepage=  loginpageObj.Login(prop.getProperty("username") , prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
