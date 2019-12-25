package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.java_script.JavaScriptHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ToDo_page;


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
        toDoPage.renameFunction(taskName_2, renameTask_0);
        Thread.sleep(5000);
        AssertionHelper.makeTrue();
    }
}
