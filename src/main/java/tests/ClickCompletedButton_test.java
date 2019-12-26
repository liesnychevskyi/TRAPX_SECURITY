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
        ToDo_page toDoPage = new ToDo_page(driver); // make instance of maine page
        toDoPage.checkTheLogo(); // check the logo and to be sure that on landing page
        toDoPage.createTask(taskName_0); // create the task
        toDoPage.createTask(taskName_1); // create the task
        toDoPage.createTask(taskName_2); // create the task
        toDoPage.createTask(taskName_3); // create the task
        toDoPage.createTask(taskName_4); // create the task
        toDoPage.itemsLeftQuantity(quantity_before); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);
        int res[] = toDoPage.getSingleCoordinates(toDoPage.checkboxDone_button); // It takes automatically x, y coordinates of machine where is test running and puts is into the test
        toDoPage.clickCheckboxButtonTaskCompleted(res[0], res[1]);
        Thread.sleep(5000);
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);
        toDoPage.clickCompletedButton();
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }
}
