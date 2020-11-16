package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import testUtil.TestUtilTimeout;
import testUtil.WebEventListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public static Properties prop ;
   
   public static EventFiringWebDriver e_driver;
   public static WebEventListener eventListener;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/Chaudhary/Documents/GIT_Projects/FreeCRMTest/src/main/java/config/config.properties");
        prop.load(fis);
    }

    public static void initialization() throws IOException
    {
        String browserName= prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver" , "/Users/Chaudhary/Documents/Drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("FF"))
        {
          //  System.setProperty("webdriver.geeko.driver" , "D:\\ChromeDriver\\GeekoDriver\\geckodriver.exe");
            driver = new ChromeDriver();
        }
        
        e_driver = new EventFiringWebDriver(driver);
        //now create an object of eventListnerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        
       
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtilTimeout.Page_Timeout , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtilTimeout.Implicit_Timeout , TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
        
        
    }


}
