import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikiLoginTest {
  WebDriver wd;

  @BeforeClass
  public void setUp() {
    wd =  new ChromeDriver();
    wd.get("https://www.wikipedia.org/");
  }

  @Test
  public void testLogin(){
    //SelectLanguage
    wd.findElement(By.cssSelector("#js-link-box-en")).click();

    //initLogin
    wd.findElement(By.cssSelector("#pt-login")).click();

    //fillLoginForm
    wd.findElement(By.name("wpName")).click();
    wd.findElement(By.name("wpName")).clear();
    wd.findElement(By.name("wpName")).sendKeys("hjgjhgj");


    wd.findElement(By.id("wpPassword1")).click();
    wd.findElement(By.id("wpPassword1")).clear();
    wd.findElement(By.id("wpPassword1")).sendKeys("jkhkjhkjhkh");

    wd.findElement(By.cssSelector("button[value='Log in']")).click();
  }

  @AfterClass
  public void tearDown(){
    wd.quit();

  }
}
