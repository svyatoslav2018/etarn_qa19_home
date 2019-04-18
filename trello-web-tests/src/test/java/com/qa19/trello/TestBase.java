package com.qa19.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //click login button
        clickLoginButton();
        login("elena.telran@yahoo.com", "12345.com");

        //  elena.telran@yahoo.com 12345.com
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[type=submit]"));
    }

    public void typeBoardName() {
        type(By.cssSelector("[placeholder='Add board title']"), "new");
    }

    public void initBoardCreation() {
        clickOnPlusButtonOnHeader();
        click(By.className("js-new-board"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[aria-label='Create Board or Organization']"));
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void login(String userName, String password) {
        // type name
        type(By.name("user"), userName);
        //type password
        type(By.id("password"), password);
        click(By.id("login"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }
}
