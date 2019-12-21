package methods_core.java_script;

import methods_core.loger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper
{
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(JavaScriptHelper.class);
    //===========================================================//

    public JavaScriptHelper(WebDriver driver)
    {
        this.driver = driver;
        log.info("JavaScriptHelper has been initialized successfully");
    }
    //============================================================//
    public Object executeScript(String script)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }
    /**
     *
     * @param script
     * @param args
     * @return
     */
    //============================================================//
    public Object executeScript(String script, Object...args)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    //============================================================//
    public void scrollToElement(WebElement element)
    {
        log.info("Scroll to WebElement...");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
    }
    //============================================================//
    public void scrollToElementAndClick(WebElement element)
    {
        scrollToElement(element);
        element.click();
        log.info("Element is clicked" + element.toString());
    }
    //============================================================//
    public void scrollIntoView(WebElement element)
    {
        log.info("Scroll till web element");
        executeScript("arguments[0].scrollIntoView()", element);
    }
    //============================================================//
    public void scrollIntoViewAndClick(WebElement element)
    {
        scrollIntoView(element);
        element.click();
        log.info("Element is clicked" + element.toString());
    }
    //============================================================//
    public void scrollDownVertically()
    {
       log.info("Scrolling down vertically");
       executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //===========================================================//
    public void scrollUpVertically()
    {
        log.info("Scrolling up vertically");
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //===========================================================//
    public void scrollDownByPixel(int pixel)
    {
        executeScript("window.scrollBY(0, "+pixel+")");
    }
    //===========================================================//
    public void scrollUpnByPixel(int pixel)
    {
        executeScript("window.scrollBY(0,-"+pixel+")");
    }
    //===========================================================//
    public void zoomInBy100Percentage()
    {
        executeScript("document.body.style.zoom='100%'");
    }
    //===========================================================//
    public void zoomInBy60Percentage()
    {
        executeScript("document.body.style.zoom='60%'");
    }
    //===========================================================//
    public void clickElementUsingJavaScript(WebElement element)
    {
        executeScript("arguments[0].click();", element);
    }
    //===========================================================//
    public void doubleClick(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');"+
         "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+
         "arguments[0].dispatchEvent(evt);", element);
    }
    public void sendKeys(WebElement element)
    {
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("document.getElementByXPath('"+element+"').value='"+text+"';");

        //WebElement webl = driver.findElement(By.xpath(“xpath_expression”));
        ((JavascriptExecutor) driver).executeScript ("arguments[0].value='Avinash Mishra';", element);

        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //String text = js.executeScript("return document.getElementByXpath('some_id').innerHTML").toString();

        // Initialize JS object
        //JavascriptExecutor JS = (JavascriptExecutor)webdriver;
        //JS.executeScript("document.getElementById('User').value='Abha_Rathour'");

    }




}
