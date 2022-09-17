package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
    Amazon sayfasına gidelim
    1- 3 farklı test methodu oluşturalım
    -URL'nin amazon içerdigini test edelim
    -Title'ın facebook içermediğini test edelim
    -sol üst köşede amazon logosunun göründüğünü test edelim

     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    //assertTrue
    //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    // Parametre olarak iki değer alır.
    // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
    //assertFalse
    //beklenen bir sonucun false olması durumunda kullanılır.
    // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
    // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        //-URL'nin amazon içerdigini test edelim
        String expectedUrl = "amazon";
        String atualUrl = driver.getCurrentUrl();
        Assert.assertTrue(atualUrl.contains(expectedUrl));


    }

    @Test
    public void test2() {
        //-Title'ın facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test3() {
        //-sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4() {
        //Url'nin https://www.facebook.com oldugunu test edelim
        String expectedUrl = "https://www.facebook.com";
        String atualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("Url'ler eşit değilse ",atualUrl,expectedUrl);
    }
}
