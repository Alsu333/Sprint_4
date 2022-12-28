package scooterTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.HomePageScooter2;

import java.util.concurrent.TimeUnit;

public class CheckAccordion2Test {
    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkAccordions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter2 homePageScooterTest = new HomePageScooter2(driver); //создали объект класса домашней страницы;
        homePageScooterTest.WaitForLoadPage(); // ожидание загрузки страницы
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,2500)"); // прокрутка до нужных элементов
        homePageScooterTest.clickCookingButton();
        Assert.assertTrue(homePageScooterTest.CheckAllElementsIsDisplayed());

    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

}
