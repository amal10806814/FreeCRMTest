package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement HomePageIcon;

    @FindBy(xpath = "//span[contains(text(), 'amal chaudhary')]")
    WebElement user;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement Contacts;
    
    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement Deals;

    public HomePage () throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public Boolean verifyLogo()
    {
       return HomePageIcon.isDisplayed();
    }

    public Boolean verifyUser()
    {
        return user.isDisplayed();
    }

    public ContactsPage clickContacts() throws IOException {
         Contacts.click();
         return new ContactsPage();
    }
    
    public DealsPage clickDeals() throws IOException
    {
    	Deals.click();;
    	return new DealsPage();
    }

}
