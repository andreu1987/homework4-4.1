package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

import  org.junit.jupiter.api.Assertions;

public  abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    protected WaitTools waitTools;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        waitTools = new WaitTools(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    // метод = ждем когда появится элемент
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    public void isElementDisplayed (By elementBy){
        waitVisibility(elementBy);
        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed());
    }


}
