package scooterTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.OrderPage;
import java.util.concurrent.TimeUnit;


public class NewOrderPageTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void NewOrderPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookingButton();
        orderPage.clikcOrderButtonHider();
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
        orderPage.ChooseDate("26.12.2022");
        orderPage.clickTermsRent();
        orderPage.chooseTermsRent();
        orderPage.clickColorScooter();
        orderPage.commentClick();
        orderPage.sendComment("Хочу закончить задание!");
        orderPage.clickOrderButton();
        orderPage.DisplayWindowOrder();
        orderPage.ClickOrderButton();
        orderPage.CheckWidowOrder();
        Assert.assertTrue(orderPage.CheckWidowOrder());

    }
    @After
    public void tearDown(){
       driver.quit();
    }
}
