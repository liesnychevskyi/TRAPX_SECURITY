package tests;

import methods_core.actions.MouseActions;
import methods_core.assertion.AssertionHelper;
import methods_core.java_script.JavaScriptHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ToDo_page;

import java.util.List;

public class RenameTask_test extends TestBase
{
    private Logger log = MyLogger.getLogger(RenameTask_test.class);
    private Actions action;
    private JavaScriptHelper js;

    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String renameTask_0 = " number 777";
    String renameTask_1 = "1). Task";


    @Test
    public void renameTest() throws InterruptedException
    {
        driver.manage().window().maximize();
        log.info("Window maximized..");
        driver.get("http://todomvc.com/examples/react/#/");
        log.info("Get to the page..");
        ToDo_page toDoPage = new ToDo_page(driver);
        toDoPage.createTask(taskName_0);
        toDoPage.createTask(taskName_1);
        toDoPage.createTask(taskName_2);
        Thread.sleep(7000);

        //WebElement taskList = driver.findElement(By.xpath("//ul[@class='todo-list']"));
        //List<WebElement> taskList = driver.findElements(By.xpath("//div[@class='view']"));
        List<WebElement> taskList = driver.findElements(By.xpath("//label[@data-reactid]"));

        action = new Actions(driver);
        //Select select = new Select(taskList);
        //select.selectByIndex(0);

        for(WebElement e : taskList)
        {
            if(e.getText().equalsIgnoreCase(taskName_2))
            {
                System.out.println("element is: " + e.getText());
                js = new JavaScriptHelper(driver);
                js.doubleClick(e);
                //js.sendKeys(e);

                //JavascriptExecutor js = (JavascriptExecutor) driver;
                //js.executeScript("document.getElementByXPath('//label[@data-reactid]').value='ddddddd'");
            }
        }

        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }
}
