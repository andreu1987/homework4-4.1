package test;

import factory.DriveFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.MainePageDuckduckgo;

public class Search_Test {

    private WebDriver driver;
    private MainePageDuckduckgo mainePageDuckduckgo;

    @BeforeEach
    public void beforeEach(){
        this.driver = new DriveFactory().create();
    }

    @Test
    public void Search_test(){
       new MainePageDuckduckgo(driver).goTo()
                                      .setInputText()
                                      .clickElement()
                                      .checkPageIsCorrect();

    }

    @AfterEach
    public void finish(){
         if (driver != null){
             driver.quit();
        }
    }


}
