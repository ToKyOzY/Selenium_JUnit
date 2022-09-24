package day12;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileExistUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@name='file']"));
        /*
        Dosya sec butonuna direekt click yapmayabiliriz cunku vindows'a mudaheleye izin vermeyebilir
        bu yuzden dosya sec butonunu direkt locate edip sendkeys methodu ile
        String degiskene atadıgımız dosya yolumuzu göndeririz.
         */
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\Zeynep Sarıkaya\\Desktop\\text.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());




    }
}
