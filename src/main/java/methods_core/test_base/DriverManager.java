package methods_core.test_base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager
{
    public WebDriver driver;


    public WebDriver chromeDriver()
    {
        try
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return driver;
    }
    //-------------------------------------------------------------------------||firefox
    public WebDriver firefoxDriver(String address)
    {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get(address);
        return driver;
    }
    //--------------------------------------------------------------------------||edge
    public WebDriver edgeDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
    //--------------------------------------------------------------------------||IE
    public WebDriver internetExplorerDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
    //---------------------------------------------------------------------------||opera
    public WebDriver operaDriver()
    {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        return driver;
    }
    //-------------------------------------------------------------------------||tearDown

}
