package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ToDo_page;

public class ClickAllButton_test extends TestBase
{
    private Logger log = MyLogger.getLogger(ClickAllButton_test.class);
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
    public void clickAllButton() throws InterruptedException
    {
        ToDo_page toDoPage = new ToDo_page(driver); // make instance of maine page
        toDoPage.checkTheLogo(); // check the logo and to be sure that on landing page
        toDoPage.createTask(taskName_0); // create the task
        toDoPage.createTask(taskName_1); // create the task
        toDoPage.createTask(taskName_2); // create the task
        toDoPage.createTask(taskName_3); // create the task
        toDoPage.createTask(taskName_4); // create the task
        toDoPage.itemsLeftQuantity(quantity_before); // check quantity of created (not done sing tasks)
        toDoPage.clickCheckboxButtonTaskCompleted(x_0, y_0);
        toDoPage.clickActiveButton();
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        toDoPage.clickAllButton();
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }
}
