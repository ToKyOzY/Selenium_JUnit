package z_practice.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import z_practice.repetitions.R02_Utilities;

import java.util.Arrays;
import java.util.List;

public class Q05 extends R02_Utilities {
    @Test
    public void test(){
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));
        //5 Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Nutella", Keys.ENTER);
        //6 Bulunan sonuc sayisini yazdirin
        System.out.println("Result : "+driver.findElement(By.xpath("//*[text()='Yaklaşık 126.000.000 sonuç bulundu']")).getText());
        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       List<WebElement> result=driver.findElements(By.xpath("//*[text()='Yaklaşık 126.000.000 sonuç bulundu']"));
        System.out.println(result.stream().findFirst().get().getText().split(" ")[1]);
        //8 Sayfayi kapatin
    }

}
