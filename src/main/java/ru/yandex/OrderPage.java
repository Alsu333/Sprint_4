package ru.yandex;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.openqa.selenium.Keys.*;

public class OrderPage {

    private WebDriver webDriver;
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private By orderButtonHider = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]"); //кнопка заказа Вверху страницы
    private By orderButtonFooter = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button"); // кнопка Заказа внизу страницы

    private By NameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input"); // поле имени
    private By SurnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"); // поле Фамилии
    private By AddressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input"); // поле адреса
    private By SubwayField = By.className("select-search__value"); //текстбокс с выбором станции метро
    private By TelephoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input"); // поле номера телефона
    private By ThenButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button"); // кнопка далее на странице заказа
    private By cookingButton = By.className("App_CookieButton__3cvqF"); // кнопка согласия обработки данных
    private By dateForRide = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input"); // поле для выбора даты поездки
    private By termsRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]"); // поле выбора срока аренды с дропдауном
    private By ColorScooter = By.xpath("//*[@id=\"grey\"]"); // поле выбора цвета
    private By Comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input"); // поле комментария
    private By OrderButtonEnd = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]"); // кнопка заказа на странице
    private By WindowOrderQuestion = By.className("Order_Modal__YZ-d3");
    private By YesOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    private  By orderWindow = By.xpath("/html/body/div/div/div[2]/div[5]");


    public void clikcOrderButtonHider() { //клик по кнопке Заказать вверху страницы
        webDriver.findElement(orderButtonHider).click();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")));
    }
    public void clikOrderButtonFooter(){ //клик по кнопке Заказать внизу страницы
        webDriver.findElement(orderButtonFooter).click();
    }
    public void NameGet(String Name){
        webDriver.findElement(NameField).sendKeys(Name); // вводим значение имени
    }
    public void SurnameGet (String Surname){
        webDriver.findElement(SurnameField).sendKeys(Surname); // вводим значение фамилии
    }
    public void AddressGet (String Address){
        webDriver.findElement(AddressField).sendKeys(Address); // вводим значение адреса
    }
    public void ClickChooseSubway(){ // кликаем по дропдпйну
        webDriver.findElement(SubwayField).click();
    }
    //public void ChooseSubway (){
        //webDriver.findElement(By.className("select-search__input")).

    public void TelephoneGet(String Telephone){
        webDriver.findElement(TelephoneField).sendKeys(Telephone);
    }
    public void ClickThenButton(){
        webDriver.findElement(ThenButton).click();
    }
    public void WaitForLoadPage() {
        new WebDriverWait(webDriver, 10);
    }
    public void clickCookingButton() {
        webDriver.findElement(cookingButton).click();
    }


    public void ChooseMetro() {
        WebElement subway = webDriver.findElement(By.className("select-search__select"));
        subway.getText();// получили список текста всех метро а дропдауне
        subway.click();
        //subway.sendKeys(ARROW_DOWN, Keys.ENTER); System.out.println(subway.getText());
        //new WebDriverWait(webDriver, 10)
               // .until(ExpectedConditions.elementToBeClickable(dateForRide));
    }

    public void ChooseDateClick() {
    webDriver.findElement(dateForRide).click();
    }
    public void ChooseDateClick1() {
        webDriver.findElement(dateForRide).sendKeys(ENTER);
    }
    public void ChooseDate(String date) {
        webDriver.findElement(dateForRide).sendKeys(date);
    }
    public void clickTermsRent() { // кликнуть срок аренды
        webDriver.findElement(termsRent).click();
    }
    public void chooseTermsRent(){ // выбрать срок аренды
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]")).click();
    }
    public void clickColorScooter(){ //выбор цвета самоката
        webDriver.findElement(ColorScooter).click();
    }
    public void commentClick(){ //оставить комментарии
        webDriver.findElement(Comment).click();
    }
    public void sendComment(String comment){
        webDriver.findElement(Comment).sendKeys(comment);
    }
    public void clickOrderButton() {
        webDriver.findElement(OrderButtonEnd).click();
    }
    public void DisplayWindowOrder(){
        webDriver.findElement(WindowOrderQuestion).isDisplayed();
    }
    public void ClickOrderButton(){
        webDriver.findElement(YesOrderButton).click();
    }
    public boolean CheckWidowOrder(){
        if (!webDriver.findElement(orderWindow).isDisplayed()){
            return false;
        }
        return true;
    }


}
