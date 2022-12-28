package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter2 { //класс главной страницы

    private WebDriver webDriver;
    private By cookingButton = By.className("App_CookieButton__3cvqF"); //cookie
    public HomePageScooter2(WebDriver webDriver) { //конструктор webDriver
        this.webDriver = webDriver;
    } //конструктор
    public void clickCookingButton(){
        webDriver.findElement(cookingButton).click();
    } // соглашаемся с cookies

    public void WaitForLoadPage() {
        new WebDriverWait(webDriver, 10);
    } //ожидание

    public boolean CheckAllElementsIsDisplayed (){ //цикл для выбора и прокликивание элементов
        for (int i=0; i < 8; i++) {
            webDriver.findElement(By.id("accordion__heading-" + i)).click();
            new WebDriverWait(webDriver, 8)
                    .until(ExpectedConditions.elementToBeClickable(By.id("accordion__panel-" + i)));
            if (!webDriver.findElement(By.id("accordion__panel-" + i)).isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}