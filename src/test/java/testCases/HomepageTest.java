package testCases;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomepageTest extends TestBase {

    LoginPage loginPageObj;
    HomePage homepageObj;
    ContactsPage contactPageObj;


    public HomepageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPageObj = new LoginPage();
       homepageObj = loginPageObj.Login(prop.getProperty("username" ), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void validatelogoTest()
    {
        Assert.assertTrue(homepageObj.verifyLogo());
    }

    @Test(priority = 2)
    public void validateUserTest()
    {
        Assert.assertTrue(homepageObj.verifyUser());
    }

    @Test(priority = 3)
    public void validateContactsPageTest() throws IOException {
       contactPageObj =  homepageObj.clickContacts();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
