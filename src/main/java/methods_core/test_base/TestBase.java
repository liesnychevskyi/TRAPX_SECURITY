package methods_core.test_base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import methods_core.loger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBase
{
    public static ExtentReports extentReports;
    public static ExtentTest test;
    private Logger log = MyLogger.getLogger(TestBase.class);
    public WebDriver driver;
    public static File reportDirectory;

//==================================================================================//
//    @BeforeClass // Original
//    public void zaleniumDocker() throws Exception
//    {
//      DesiredCapabilities cap = new DesiredCapabilities();
//      cap.setCapability(CapabilityType.BROWSER_NAME, org.openqa.selenium.remote.BrowserType.CHROME);
//      cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//      URL url = new URL("http://localhost:4444/wd/hub");
//      driver = new RemoteWebDriver(url,cap);
//    }
//
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }
//===================================================================================/ Boni Garcia it is online driver from Github
// We use it to avoid mistakes of compatibility versions
// If you want use different browsers, you should have the browser on testing machine
// https://github.com/bonigarcia/webdrivermanager
//===================================================================================//
    @BeforeTest
    public void beforeTest()
    {
        DriverManager driverManager = new DriverManager();
        log.info("Driver instance is created..");  // log
        driver = driverManager.chromeDriver();
        log.info("Driver is launched..");  // log
        driver.manage().window().maximize(); // maximize the browser window
        log.info("Window maximized..");  // log
        driver.get("http://todomvc.com/examples/react/#/"); // address (app under test)
        log.info("Get to the page..");  // log
    }
//===================================================================================//
    public static void logExtentReport(String log)
    {
        test.log(Status.INFO, log);
    }
//==================================================================================//
    public void getApplicationUrl(String url)
    {
        driver.get(url);
        logExtentReport("Navigate to ... " + url);
    }
//===================================================================================//
    @AfterClass
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
            log.info("Driver stopped..");  // log
        }
    }
//===================================================================================//
}

