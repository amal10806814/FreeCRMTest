package Pages;

import Base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div//div[contains(text(), 'Contacts')]")
    WebElement ContactsLogo;

//    //@FindBy(xpath = "//tr[1]//td[1]//div[@class='ui fitted read-only checkbox']")
//    @FindBy(xpath = "")
//    WebElement radioButton;


    public ContactsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public Boolean checkContactsLogo()
    {
        return ContactsLogo.isDisplayed();
    }

    public void clickRadioButton(String name)
    {
    	driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td[1]")).click();
      
    }
}
