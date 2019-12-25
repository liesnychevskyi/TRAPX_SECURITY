package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ToDo_page;

public class ClickTaskDone_test extends TestBase
{
    private Logger log = MyLogger.getLogger(ClickTaskDone_test.class);
    private Actions action;
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity_before = "5";
    String quantity_after = "4";
    int x_0 = 706;
    int y_0 = 205;
    int x_1 = 706;
    int y_1 = 264;
//        new Actions(driver).moveByOffset(706, 205).click().build().perform(); 1
//        new Actions(driver).moveByOffset(706, 264).click().build().perform(); 2
//        new Actions(driver).moveByOffset(706, 323).click().build().perform(); 3
//        new Actions(driver).moveByOffset(706, 382).click().build().perform(); 4
//        new Actions(driver).moveByOffset(706, 441).click().build().perform(); 5

    @Test
    public void taskCompleted_0() throws InterruptedException
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
        toDoPage.itemsLeftQuantity(quantity_after); // check quantity of created (not done sing tasks)
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }
//--------------------------------------------------------------------------------------//




























//        List<WebElement> checkboxButtonsList = driver.findElements(By.xpath("//input[@class='toggle']"));
//        java.util.Iterator<WebElement> i = checkboxButtonsList.iterator();
//        while (i.hasNext())
//        {
//            WebElement ele = i.next();
//        }
//-------------------------------------------------------------------------------------// Take coordinates of elements
//    @Test(priority = 2)
//    public void getCoordinates() throws Exception
//    {
//        List<WebElement> checkboxButtonsList = driver.findElements(By.xpath("//input[@class='toggle']"));
//        for(WebElement e : checkboxButtonsList)
//        {
//            //Locate element for which you wants to retrieve x y coordinates.
//            //WebElement Image = driver.findElement(By.xpath("//input[@class='toggle']"));
//            //Used points class to get x and y coordinates of element.
//            Point classname = e.getLocation();
//            int xcordi = classname.getX();
//            System.out.println("Element's Position from left side " + xcordi + " x - pixels.");
//            int ycordi = classname.getY();
//            System.out.println("Element's Position from top " + ycordi + " y - pixels.");
//            System.out.println("||-----------------------------------------------------||");
//        }
//    }
//----------------------------------------------------------------------------------------//
}
