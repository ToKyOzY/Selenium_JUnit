package day11;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim= driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        isim.sendKeys("Zeynep");
        actions.sendKeys(Keys.TAB).sendKeys("Sarıkaya").sendKeys(Keys.TAB).sendKeys("zzz@gmail.com").
                sendKeys(Keys.TAB).sendKeys("zzz@gmail.com").sendKeys(Keys.TAB).sendKeys("123456").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("8").sendKeys(Keys.TAB).
                sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("1985").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.LEFT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

    }
}
