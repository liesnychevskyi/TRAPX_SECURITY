package methods_core.actions;

import methods_core.java_script.JavaScriptHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions
{
    private WebDriver driver;
    private Actions action;

    public MouseActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void doubleClick(WebElement element)
    {
        action = new Actions(driver).doubleClick(element);
        action.build().perform();
    }

    public void mouseOver(WebElement element)
    {
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void rightClick(WebElement element)
    {
        action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void overMouseOnTask(WebElement element)
    {
        JavaScriptHelper js = new JavaScriptHelper(driver);
        js.mouseOver(element);
    }

}
