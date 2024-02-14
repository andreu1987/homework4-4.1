package test;

import factory.DriveFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.MainePageOtusHome;

public class Checking_Test {
    private WebDriver driver;
    private MainePageOtusHome mainePageOtusHome;

    @BeforeEach
    public void beforeEach(){
        this.driver = new DriveFactory().create();
    }

    @Test
    public void CheckingTest(){
        new MainePageOtusHome(driver).goTo()
                                     .fullscreen() // размер экрана
                                     .getSize() // размер экрана
                                     .clickElement() // клик по элементу
                                     .elementLoadTimeout() // ожидание элемента
                                     .checkPicture(); // проверка элемента
    }

    @AfterEach
    public void finish(){
        if (driver != null){
            driver.quit();
        }
    }
}
