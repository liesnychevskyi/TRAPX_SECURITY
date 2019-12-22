package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ToDo_page;

public class ClickCompletedButton_test extends TestBase
{
    private Logger log = MyLogger.getLogger(CreateTask_test.class);
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity_before = "5";
    String quantity_after = "4";
    int x_0 = 706;
    int y_0 = 205;

    @Test
    public void clickActiveButton() throws InterruptedException
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
        toDoPage.itemsLeftQuantity(quantity_before); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);
        toDoPage.clickCheckboxButtonTaskCompleted(x_0, y_0);
        Thread.sleep(5000);
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);
        toDoPage.clickCompletedButton();
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)

        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }
}
