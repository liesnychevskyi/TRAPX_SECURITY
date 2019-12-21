package pages;

import methods_core.actions.MouseActions;
import methods_core.assertion.AssertionHelper;
import methods_core.loger.MyLogger;
import methods_core.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToDo_page //extends DriverManager
{
    private final Logger log = MyLogger.getLogger(ToDo_page.class);
    public WebDriver driver;
    WaitHelper waitHelper;
    MouseActions action;
    //----------------------------------------------------------------//
    @FindBy(xpath = "//h1[@data-reactid]")
    private WebElement lable;

    @FindBy(xpath = "//input[@placeholder='What needs to be done?']")
    private WebElement whatNeedsToBeDone_button;

    @FindBy(xpath = "//label[@for='toggle-all']")
    private WebElement toggleAll_button;

    @FindBy(xpath = "//input[@class='toggle']")
    private WebElement checkboxDone_button;

    @FindBy(xpath = "//div[@class='view']")
    private WebElement tasksList;

    @FindBy(xpath = "//strong[@data-reactid]")
    private WebElement itemsLeft_string;

    @FindBy(xpath = "//a[@class='selected']")
    private WebElement all_button;

    @FindBy(xpath = "//a[@href='#/active']")
    private WebElement active_button;

    @FindBy(xpath = "//a[@href='#/completed']")
    private WebElement completed_button;

    @FindBy(xpath = "//button[@class='destroy']")
    private WebElement x_mark_destroy_list;

    @FindBy(xpath = "//button[@class='clear-completed']")
    private WebElement clearCompeted_button;
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
    //------------------------------------------------------------------//
    public void checkTheLogo()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(lable, 30);
        String logo = lable.getText();
        if(logo.equalsIgnoreCase("todos"))
        {
            AssertionHelper.makeTrue();
        }
    }
    //------------------------------------------------------------------//
    public void deleteTask()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(lable, 30);

    }
    //------------------------------------------------------------------//
    public void deleteAllTasks()
    {

    }
    //------------------------------------------------------------------//
    public void clickToggleAll()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(toggleAll_button, 30);
        toggleAll_button.click();
    }
    //------------------------------------------------------------------//
    public void clickCheckboxButton()
    {
        waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElementClickable(checkboxDone_button, 30);
        checkboxDone_button.click();
        boolean res = checkboxDone_button.isSelected();
        if(res == true)
        {
            AssertionHelper.makeTrue();
        }
    }
    //------------------------------------------------------------------//
    public void clickActiveButton()
    {

    }
    //------------------------------------------------------------------//
    public void renameFunction(String text)
    {
        List<WebElement> tasks = driver.findElements(By.xpath("//div[@class='view']"));
        action = new MouseActions(driver);
        for(WebElement ele : tasks)
        {
            System.out.println(ele);
//            action.doubleClick(ele);
//            ele.sendKeys(text);
        }
    }
    //------------------------------------------------------------------//
    public void clickCompletedButton()
    {

    }
    //------------------------------------------------------------------//
    public void clickClearCompletedButton()
    {

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



}
