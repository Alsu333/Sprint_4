package scooterTests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.OrderPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class NewOrderPageTestMozzila {
    private WebDriver driver;
    @Before
        public void setUp () {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.firefox.marionette","C:\\WebDriver\\bin\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
    }

    @Test
    public void NewOrderPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookingButton();
        orderPage.clikcOrderButtonHider();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")));
        orderPage.WaitForLoadPage();
        orderPage.NameGet("Алсу");
        orderPage.SurnameGet("Нутфуллина");
        orderPage.AddressGet("Москва");
        orderPage.ClickChooseSubway();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.className("select-search__select")));
        orderPage.ChooseMetro();
        orderPage.TelephoneGet("89322003636");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")));
        orderPage.ClickThenButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        orderPage.ChooseDateClick();
        orderPage.ChooseDateClick1();
        orderPage.ChooseDate("06.01.2023");
        orderPage.clickTermsRent();
        orderPage.chooseTermsRent();
        orderPage.clickColorScooter();
        orderPage.commentClick();
        orderPage.sendComment("585");
        orderPage.clickOrderButton();
        orderPage.DisplayWindowOrder();
        orderPage.ClickOrderButton();


    }
    @After
    public void ends (){

        driver.quit();
    }
}
