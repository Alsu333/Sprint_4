package scooterTests.OrderPageNewData;
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

public class NewOrderPageTestNewData {

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
        OrderPage orderPage1 = new OrderPage(driver);
        orderPage1.clickCookingButton();
        orderPage1.clikcOrderButtonHider();
        orderPage1.WaitForLoadPage();
        orderPage1.NameGet("Вакиф");
        orderPage1.SurnameGet("Маг");
        orderPage1.AddressGet("Санкт-Петербург");
        orderPage1.ClickChooseSubway();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.className("select-search__select")));
        orderPage1.ChooseMetro();
        orderPage1.TelephoneGet("89323003030");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")));
        orderPage1.ClickThenButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        orderPage1.ChooseDateClick();
        orderPage1.ChooseDateClick1();
        orderPage1.ChooseDate("28.12.2022");
        orderPage1.clickTermsRent();
        orderPage1.chooseTermsRent();
        orderPage1.clickColorScooter();
        orderPage1.commentClick();
        orderPage1.sendComment("Хочу закончить это уже!");
        orderPage1.clickOrderButton();
        orderPage1.DisplayWindowOrder();
        orderPage1.ClickOrderButton();
        orderPage1.CheckWidowOrder();
        Assert.assertTrue(orderPage1.CheckWidowOrder());

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

