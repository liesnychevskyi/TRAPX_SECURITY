package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ToDo_page;

public class ClickSetAllTasksIsDone_test extends TestBase
{
    private Logger log = MyLogger.getLogger(ClickSetAllTasksIsDone_test.class);
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity = "5";
    String itemsLeft = "0";

    @Test
    public void allTasksIsDone() throws InterruptedException
    {
        driver.manage().window().maximize(); // maximize the browser window
        log.info("Window maximized..");  // log
        driver.get("http://todomvc.com/examples/react/#/"); // address (app under test)
        log.info("Get to the page..");  // log
        ToDo_page toDoPage = new ToDo_page(driver); // make instance of maine page
        log.info("ToDo_page instance is created..");  // log
        toDoPage.checkTheLogo(); // check the logo and to be sure that on landing page
        log.info("Logo is verified..");  // log
        toDoPage.createTask(taskName_0); // create the task
        log.info("Created task_0");  // log
        toDoPage.createTask(taskName_1); // create the task
        log.info("Created task_1");
        toDoPage.createTask(taskName_2); // create the task
        log.info("Created task_2");
        toDoPage.createTask(taskName_3); // create the task
        log.info("Created task_3");
        toDoPage.createTask(taskName_4); // create the task
        log.info("Created task_4");
        toDoPage.itemsLeftQuantity(quantity); // check quantity of created (not done sing tasks)
        log.info("Quantity is verified..");

        log.info("Sleeping 5000 ms");
        toDoPage.clickAllDoneButton();
        toDoPage.checkItemsLeft(itemsLeft);
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }

}
