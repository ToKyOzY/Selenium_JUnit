package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        //1- Amazon Sayfasina girelim
        driver.get("http://amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        /*
        Eger bize verilen testte sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driver'in window handle degerini String bir degiskene atarız
        Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar eilk sayfaaya dönmemiz istenirse
        String degiskene atadıgımız window handle degerleriyle sayfalar arası geçiş yapabiliriz
         */
        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon"));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Best Buy"));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        String result=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertTrue(result.contains("Java"));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("//*[@class='logo'][1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
