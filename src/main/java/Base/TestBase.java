package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testUtil.TestUtilTimeout;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public static Properties prop ;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\FreeCRMTest\\src\\main\\java\\config\\config.properties");
        prop.load(fis);
    }

    public static void initialization()
    {
        String browserName= prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver" , "D:\\ChromeDriver\\new\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("FF"))
        {
            System.setProperty("webdriver.geeko.driver" , "D:\\ChromeDriver\\GeekoDriver\\geckodriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtilTimeout.Page_Timeout , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtilTimeout.Implicit_Timeout , TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }


}
