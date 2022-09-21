package z_practice.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import z_practice.repetitions.R02_Utilities;

public class Q09 extends R02_Utilities {
    @Test
    public void test() throws InterruptedException {
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        driver.manage().window().maximize();
        //5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Spend less"));
        //6 Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@class='nav-a  '][4]")).click();
        Thread.sleep(2000);
        //7 Birthday butonuna basin
        driver.findElement(By.xpath("//*[@class='bxc-grid__column  bxc-grid__column--2-of-12   bxc-grid__column--light'][2]")).click();
        Thread.sleep(2000);
        //8 Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@alt='Amazon.com eGift Card'][1]")).click();
        Thread.sleep(2000);
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//*[@id='gc-mini-picker-amount-1'][1]")).click();
        Thread.sleep(2000);
        //10-Urun ucretinin 25$ oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-box-inner'][1]")).isDisplayed());

        //10-Sayfayi kapatin
    }

}
