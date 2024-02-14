package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainePageDuckduckgo extends BasePage {

    private String duckduckgoUrl = System.getProperty("duckduckgo.url");
    private static final String TITLE = "ОТУС";
    @FindBy(css = "input[name='q']")
    private WebElement fieldInput;

    @FindBy(css = "button[type='submit']")
    private WebElement clickElement;

    public MainePageDuckduckgo(WebDriver driver) {
        super(driver);
    }

    // переход на сайт
    public MainePageDuckduckgo goTo(){
        driver.get(duckduckgoUrl);
        return this;
    }

    // ввод в поле
    public MainePageDuckduckgo setInputText(){
        fieldInput.clear();
        fieldInput.sendKeys(TITLE);
        return this;
    }

    // кликнуть по кнопки
    public MainePageDuckduckgo clickElement (){
        clickElement.click();
        return this;
    }

    public MainePageDuckduckgo implicitlyWaitText(){
        waitVisibility
                (By.xpath("//span[contains(text(),'Онлайн‑курсы для профессионалов," +
                        "дистанционное обучение современным ...')]"));
        return this;
    }



    public MainePageDuckduckgo checkPageIsCorrect(){
        isElementDisplayed
                (By.xpath("//span[contains(text(),'Онлайн‑курсы для профессионалов, " +
                        "дистанционное обучение современным ...')]"));
        System.out.println("Текст успешно найден");
        return this;
    }


}
