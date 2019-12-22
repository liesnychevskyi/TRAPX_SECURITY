package tests;

import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.test_base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ToDo_page;

import java.util.List;

public class DeleteTask_test extends TestBase {
    private Logger log = MyLogger.getLogger(DeleteTask_test.class);
    String taskName_0 = "1). Task";
    String taskName_1 = "2). Task";
    String taskName_2 = "3). Task";
    String taskName_3 = "4). Task";
    String taskName_4 = "5). Task";
    String quantity = "5";

    @Test(priority = 1)
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

        //List<WebElement> deleteButtonsList = driver.findElements(By.xpath("//button[@class='destroy']"));
        //WebElement deleteButtonsList = driver.findElement(By.xpath("//button[@class='destroy']"));

//------------------------------------------------------------------------------------------//

//------------------------------------------------------------------------------------------//
//            Select select = new Select(deleteButtonsList);
//            select.selectByIndex(0);
//-------------------------------------------------------------------------------------------//
//        for(WebElement e : deleteButtonsList)
//        {
//            System.out.println("Element is :" + e);
//            e.click();
//        }
//------------------------------------------------------------------------------------------//
//        List<WebElement> deleteButtonsList = driver.findElements(By.xpath("//button[@class='destroy']"));
//        java.util.Iterator<WebElement> i = deleteButtonsList.iterator();
//        while (i.hasNext())
//        {
//            WebElement ele = i.next();
//            if (ele.getText().isEmpty())
//            {
//                System.out.println("Location of element " + ele.getLocation());
//                // do something in else perhaps
//            }
//        }
//-------------------------------------------------------------------------------------------//
        Thread.sleep(5000);  // Time to see the result
        AssertionHelper.makeTrue(); // true if all done
    }

//-------------------------------------------------------------------------------------------//
    @Test(priority = 2)
    public void getCoordinates() throws Exception
    {
        //Locate element for which you wants to retrieve x y coordinates.
        WebElement Image = driver.findElement(By.xpath("//input[@class='toggle']"));
        //Used points class to get x and y coordinates of element.
        Point classname = Image.getLocation();
        int xcordi = classname.getX();
        System.out.println("Element's Position from left side " + xcordi + " pixels.");
        int ycordi = classname.getY();
        System.out.println("Element's Position from top " + ycordi + " pixels.");
    }
}