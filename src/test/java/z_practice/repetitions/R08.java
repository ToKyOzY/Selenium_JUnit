package z_practice.repetitions;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class R08 extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı.
        //driver.switchTo( ).alert( ).accept( );
        //● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
        //driver.switchTo( ).alert( ).dismiss( );
        //● getText() => Uyarıdaki(alert) mesajı almak için.
        //driver.switchTo( ).alert( ).getText( );
        //● sendKeys("Text") => Uyarı(alert) text kutusuna text göndermek için
        //driver.switchTo( ).alert( ).sendKeys("Text")


        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //"You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals("You successfully clicked an alert",driver.findElement(By.xpath("//*[@id='result']")).getText());


    }
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //"successfuly" icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText().contains("successfuly"));
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Zeynep");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You entered: Zeynep']")).isDisplayed());

    }
}
