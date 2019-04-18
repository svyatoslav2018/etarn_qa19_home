package com.qa19.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase2 {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd =  new ChromeDriver();
        wd.get("https://www.wikipedia.org/");
    }

    public void clickOnButtonLogin(By selector) {
        wd.findElement(selector).click();
    }

    public void fillLoginForm(By wpName) {
        clickOnButtonLogin(wpName);
        wd.findElement(wpName).clear();
        wd.findElement(wpName).sendKeys("hjgjhgj");
    }

    public void fillPasswordForm(By wpPassword1) {
        clickOnButtonLogin(wpPassword1);
        wd.findElement(wpPassword1).clear();
        wd.findElement(wpPassword1).sendKeys("jkhkjhkjhkh");
    }

    public void initLogin() {
        clickOnButtonLogin(By.cssSelector("#pt-login"));
    }

    public void selectLanguage() {
        clickOnButtonLogin(By.cssSelector("#js-link-box-en"));
    }
    @AfterClass
    public void tearDown(){
        wd.quit();

    }
}
