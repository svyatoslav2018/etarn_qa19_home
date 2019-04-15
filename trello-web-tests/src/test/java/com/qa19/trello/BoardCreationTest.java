package com.qa19.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTest {
  WebDriver wd;
  @BeforeClass
  public void setUp(){
    wd = new ChromeDriver();
    wd.get("https://trello.com/");
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //click login button
    wd.findElement(By.linkText("/login")).click();
    // type name
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("elena.telran@yahoo.com");
//type password
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("12345.com");

    wd.findElement(By.id("login")).click();


  //  elena.telran@yahoo.com 12345.com
  }

  @Test
  public  void createBoardTest(){
    //clickOnPlusButtonOnHeader
wd.findElement(By.cssSelector("[aria-label='Create Board or Organization']")).click();
wd.findElement(By.className("js-new-board")).click();
//typeBoardName
wd.findElement(By.cssSelector("[placeholder='Add board title']")).click();
wd.findElement(By.cssSelector("[placeholder='Add board title']")).clear();
wd.findElement(By.cssSelector("[placeholder='Add board title']")).sendKeys("new");
//submitBoardCreation
wd.findElement(By.cssSelector("[type=submit]")).click();

  }

  @AfterClass
  public void tearDown(){
    wd.quit();

  }
}
