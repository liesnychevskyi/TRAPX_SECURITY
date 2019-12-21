package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ToDo_page;

public class CreateTask_test extends TestBase
{
    private Logger log = MyLogger.getLogger(TestBase.class);
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity = "5";

    @Test
    public void toDoTaskCreation() throws InterruptedException
    {
        driver.manage().window().maximize();
        log.info("Window maximized..");
        driver.get("http://todomvc.com/examples/react/#/");
        log.info("Get to the page..");
        ToDo_page toDoPage = new ToDo_page(driver);
        toDoPage.createTask(taskName_0);
        toDoPage.createTask(taskName_1);
        toDoPage.createTask(taskName_2);
        toDoPage.createTask(taskName_3);
        toDoPage.createTask(taskName_4);
        toDoPage.itemsLeftQuantity(quantity);

        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }

}
