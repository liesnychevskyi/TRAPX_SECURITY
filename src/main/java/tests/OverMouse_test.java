package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ToDo_page;

import java.util.List;

public class OverMouse_test extends TestBase
{
    private Logger log = MyLogger.getLogger(OverMouse_test.class);
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity = "5";

    @Test
    public void toDoTaskCreation() throws InterruptedException
    {
        driver.manage().window().maximize(); // maximize the browser window
        log.info("Window maximized..");  // log
        driver.get("http://todomvc.com/examples/react/#/"); // address (app under test)
        log.info("Get to the page..");  // log
        ToDo_page toDoPage = new ToDo_page(driver); // make instance of maine page
        toDoPage.checkTheLogo(); // check the logo and to be sure that on landing page
        toDoPage.createTask(taskName_0); // create the task
        toDoPage.createTask(taskName_1); // create the task
        toDoPage.createTask(taskName_2); // create the task
        toDoPage.createTask(taskName_3); // create the task
        toDoPage.createTask(taskName_4); // create the task
        toDoPage.itemsLeftQuantity(quantity); // check quantity of created (not done sing tasks)


//--------------------------------------------------------------------------------//
        List<WebElement> checkboxButtonsList = driver.findElements(By.xpath("//label[@data-reactid]"));
        for(WebElement e : checkboxButtonsList)
        {
            if(e.getText().equalsIgnoreCase(taskName_0))
            {
                Actions builder = new Actions(driver);
                builder.moveToElement(e).build().perform();
                e.click();
            }
        }
//-------------------------------------------------------------------------------//
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }

}
