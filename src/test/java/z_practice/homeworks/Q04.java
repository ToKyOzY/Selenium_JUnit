package z_practice.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import z_practice.repetitions.R02_Utilities;

import java.util.List;

public class Q04 extends R02_Utilities {
    @Test
    public void test() throws InterruptedException {
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        Assert.assertFalse(driver.getTitle().equals("facebook"));
        System.out.println("Dogru sayfa baslik: "+driver.getTitle());
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        //4.https://www.walmart.com/ sayfasina gidin.
        Thread.sleep(2000);
        driver.navigate().to("https://www.walmart.com/");
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("Walmart.com"));
        //6. Tekrar “facebook” sayfasina donun
        Thread.sleep(2000);
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();

    }

}
