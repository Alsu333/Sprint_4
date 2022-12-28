package scooterTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.HomePageScooter2;

import java.util.concurrent.TimeUnit;

public class CheckAccordionMozillaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.firefox.marionette", "C:\\WebDriver\\bin\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
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
