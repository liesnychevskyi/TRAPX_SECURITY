package pages;

import methods_core.actions.MouseActions;
import methods_core.assertion.AssertionHelper;
import methods_core.assertion.VerificationHelper;
import methods_core.java_script.JavaScriptHelper;
import methods_core.loger.MyLogger;
import methods_core.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.ClickTaskDone_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ToDo_page
{
    private final Logger log = MyLogger.getLogger(ToDo_page.class);
    private WebDriver driver;
    private WaitHelper waitHelper;
    private MouseActions action;
    private JavaScriptHelper js;
    //----------------------------------------------------------------//
    @FindBy(xpath = "//h1[@data-reactid]")
    private WebElement lable;

    @FindBy(xpath = "//input[@placeholder='What needs to be done?']")
    private WebElement whatNeedsToBeDone_button;

    @FindBy(xpath = "//label[@for='toggle-all']")
    public WebElement toggleAll_button;

    @FindBy(xpath = "//input[@class='toggle']")
    public WebElement checkboxDone_button;

    @FindBy(xpath = "//div[@class='view']")
    private WebElement tasksList;

    @FindBy(xpath = "//strong[@data-reactid]")
    private WebElement itemsLeft_string;

    @FindBy(xpath = "//a[@href='#/']")
    private WebElement all_button;

    @FindBy(xpath = "//a[@href='#/active']")
    private WebElement active_button;

    @FindBy(xpath = "//a[@href='#/completed']")
    private WebElement completed_button;

    @FindBy(xpath = "//button[@class='destroy']")
    private WebElement x_mark_destroy_list;

    @FindBy(xpath = "//button[@class='clear-completed']")
    private WebElement clearCompeted_button;

    @FindBy(xpath = "//input[@ value='3). Task']")
    private WebElement edit;



    //----------------------------------------------------------------// Constructor
    public ToDo_page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //----------------------------------------------------------------// Methods
    public void createTask(String taskName)
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(whatNeedsToBeDone_button, 30);
        whatNeedsToBeDone_button.sendKeys(taskName);
        whatNeedsToBeDone_button.sendKeys(Keys.ENTER);
    }
    //----------------------------------------------------------------//
    public void checkTheLogo()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(lable, 30);
        String logo = lable.getText();
        if(logo.equalsIgnoreCase("todos"))
        {
            AssertionHelper.makeTrue();
        }
    }
    //------------------------------------------------------------------//
    public void checkElementIsNotPresent()
    {
       VerificationHelper verificationHelper = new VerificationHelper(driver);
       boolean res = verificationHelper.isNotDisplayed(clearCompeted_button);
       if(res == true)
       {
           AssertionHelper.pass();
       }
       else
       {
           AssertionHelper.fail();
       }
    }
    //------------------------------------------------------------------//
    public void deleteOneTask()
    {
        action = new MouseActions(driver);
        action.mouseOver(checkboxDone_button);
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(x_mark_destroy_list, 30);
        x_mark_destroy_list.click();
    }
    //------------------------------------------------------------------//
    public void clickClearCompletedButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(clearCompeted_button, 30);
        String res = clearCompeted_button.getText();
        if(res.equalsIgnoreCase("Clear completed"))
        {
            clearCompeted_button.click();
        }
        else
        {
            AssertionHelper.makeFalse("Attention: << Clear competed >> button error !!!");
        }
    }
    //------------------------------------------------------------------//
    public void clickToggleAll()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(toggleAll_button, 30);
        toggleAll_button.click();
    }
    //------------------------------------------------------------------//
    public void clickCheckboxButtonTaskCompleted(int x, int y)
    {
        waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
        new Actions(driver).moveByOffset(x, y).click().build().perform();
    }
    //------------------------------------------------------------------//
    public void clickActiveButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(active_button, 30);
        String res = active_button.getText();
        if(res.equalsIgnoreCase("active"))
        {
            active_button.click();
        }
        else
        {
            AssertionHelper.makeFalse("Attention: << Active >> button error !!!");
        }
    }
    //------------------------------------------------------------------//
    public void renameFunction(String taskName, String rename)
    {
        List<WebElement> taskList = driver.findElements(By.xpath("//label[@data-reactid]"));
        new Actions(driver);

        for(WebElement e : taskList)
        {
            if(e.getText().equalsIgnoreCase(taskName))
            {
                System.out.println("element is: " + e.getText());
                js = new JavaScriptHelper(driver);
                js.doubleClick(e);
                waitHelper = new WaitHelper(driver);
                waitHelper.waitForElementToBeClickableIgnoringException(edit, 30);

                edit.sendKeys(rename);
            }
        }
    }
    //------------------------------------------------------------------//
    public void clickAllButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(all_button, 30);
        String res = all_button.getText();
        if(res.equalsIgnoreCase("all"))
        {
            all_button.click();
        }
        else
        {
            AssertionHelper.makeFalse("Attention: << All >> button error !!!");
        }
    }
    //------------------------------------------------------------------//
    public void clickCompletedButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(completed_button, 30);
        String res = completed_button.getText();
        if(res.equalsIgnoreCase("completed"))
        {
            completed_button.click();
        }
        else
        {
            AssertionHelper.makeFalse("Attention: << Completed >> button error !!!");
        }
    }
    //------------------------------------------------------------------//
    public void itemsLeftQuantity(String quantity)
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(itemsLeft_string, 30);
        String res = itemsLeft_string.getText();
        System.out.println(res + " - items");
        AssertionHelper.verifyText(res, quantity);
    }
    //------------------------------------------------------------------//
    public void clickAllDoneButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(toggleAll_button, 30);
        toggleAll_button.click();
        VerificationHelper verificationHelper = new VerificationHelper(driver);
        boolean res = verificationHelper.isDisplayed(clearCompeted_button);

        if(res == true)
        {
            AssertionHelper.pass();
        }
        else
        {
            AssertionHelper.fail();
        }
    }
    //------------------------------------------------------------------//
    public void checkItemsLeft(String items)
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(itemsLeft_string, 30);
        String res = itemsLeft_string.getText();

        if(res.equals(items))
        {
            AssertionHelper.pass();
        }
        else
        {
            AssertionHelper.fail();
        }
    }
    //------------------------------------------------------------------//
    public int[] getSingleCoordinates(WebElement element)
    {
        //Locate element for which you wants to retrieve x y coordinates.
        //Used points class to get x and y coordinates of element.
        Point classname = element.getLocation();
        int xcordi = classname.getX();
        System.out.println("Element's Position from left side " + xcordi + " x - pixels.");
        int ycordi = classname.getY();
        System.out.println("Element's Position from top " + ycordi + " y - pixels.");
        System.out.println("||-----------------------------------------------------||");
        return new int[]{xcordi, ycordi};
    }
    //------------------------------------------------------------------//
    public void getMultiplesCoordinates(WebElement element)
    {
        List<WebElement> checkboxButtonsList = driver.findElements(By.xpath("//input[@class='toggle']"));

        for(WebElement e : checkboxButtonsList)
        {
            Point classname = e.getLocation();
            System.out.println("||-----------------------------------------------------||");
            int xcordi = classname.getX();
            System.out.println("Element's Position from left side " + xcordi + " x - pixels.");
            int ycordi = classname.getY();
            System.out.println("Element's Position from top " + ycordi + " y - pixels.");
        }
    }

}
