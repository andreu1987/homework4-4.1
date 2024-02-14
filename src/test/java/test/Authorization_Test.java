package test;

import factory.DriveFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.MainePageOtus;

public class Authorization_Test {
    private WebDriver driver;
    private MainePageOtus mainePageOtus;

    @BeforeEach
    public void beforeEach(){
        this.driver = new DriveFactory().create();
    }

    @Test
    public void AutTest(){
        new MainePageOtus(driver).goTo()
                                 .maximize() // размер экрана
                                 .getSize() // размер экрана
                                 .thereIsNotPopupElement()//Проверка что PopupElement нету, - "Войдите в свой акаунт"
                                 .implicitlyWaitButton() // ожидания элемента кнопка "Войти"
                                 .clickElementEnter() // клик по элементу кнопки "Войти"
                                 .thereIsPopupElement() //Проверка что PopupElement есть - "Войдите в свой акаунт"
                                 .authorizationEmail()  // ввод Email
                                 .authorizationPassword()  // ввод Password
                                 .clickElementEnterEnter()  // клик по элементу
                                 .thereIsNoButton()//Проверка что нет кнопки "Войти"
                                 .getCookies(); // вывод в лог куков

    }

    @AfterEach
    public void finish(){
        if (driver != null){
            driver.quit();
        }
    }


}
