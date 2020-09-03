package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[contains(text(), 'Contacts')]")
    WebElement ContactsLogo;

    @FindBy(name = "id")
    WebElement radioButton;


    public ContactsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public Boolean checkContactsLogo()
    {
        return ContactsLogo.isDisplayed();
    }

    public void clickRadioButton()
    {
        radioButton.click();
    }
}
