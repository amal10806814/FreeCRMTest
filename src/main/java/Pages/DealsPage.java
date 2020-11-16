package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath ="//a[@href = 'https://ui.freecrm.com/deals/new']/i")
	WebElement NewButton;

	@FindBy(xpath= "//div//input[@autocomplete= 'new-password' and @name= 'title' and @type ='text']")
	WebElement titleOne;
	
	@FindBy(xpath= "//div//input[@autocomplete= 'new-password' and @name= 'title' and @type ='text']")
	WebElement companyName;
	
	@FindBy(xpath= "//i[text(),'Save']")
	WebElement saveBtn;
	
	public DealsPage() throws IOException
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewBtn()
	{
		NewButton.click();
	}
	
	
	public void createDeal(String title, String assignTo, String company)
	{
		titleOne.sendKeys(title);
		
		Select ss = new Select(driver.findElement(By.xpath("//div[@role='listbox']")));
		
		ss.selectByVisibleText(assignTo);
		
		companyName.sendKeys(company);
		
	}
	
	public void clickSaveBtn()
	{
		saveBtn.click();
	}
	
}
