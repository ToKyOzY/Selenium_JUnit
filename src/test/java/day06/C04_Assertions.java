package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.youtube.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void titleTest1(){
        //     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);



    }

    @Test
    public void imageTest(){
        //     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]")).isDisplayed());

    }
    @Test
    public void searcBoxTest(){
        //     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());
    }
    @Test
    public void wrongtitleTest(){
        //     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unExpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(actualTitle,unExpectedTitle);
    }
}
