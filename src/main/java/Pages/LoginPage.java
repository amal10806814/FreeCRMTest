package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {

    //page factory -- Object repository

    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password ;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;

    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public String validateTitle()
    {
       return driver.getTitle();
    }

    public HomePage Login(String un , String pwd) throws IOException {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }
}
