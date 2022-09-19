package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AlertExercise {
    /*
    Bir web sitesine girdigimide karşımıza bir uyarı mesajı ya da bir butona tıkladıgımızda
    bir uyarı(alert) çıkabilir. Eğer bu uyarıya incele(sağ tık nspect) yapabiliyorsak
    bu tur alert'lere html alert denir ve istedigmiz locate'i alabilliriz.
    Ama gelen uyarı kutusuna müdehale(sag tık-incele9 edemiyorsak bu tür alert'lere js alert denir. Js alert'lere müdehale edebilmek için
    -tamam ya da ok için driver.switchTo().alert().accept(); kullanılır..
    -İptal için driver.switchTo().alert().dismiss(); kullanılır..
    -Alert içindeki mesajı almak için driver.switchTo().alert().getText(); kullanılır..
    -Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır..
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
      Thread.sleep(3000);
      driver.switchTo().alert().accept();
      String actualAlertResut= driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualAlertResut);
    }

    @Test
    public void dismisAlert() throws InterruptedException {
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
       driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
       Thread.sleep(3000);
       driver.switchTo().alert().dismiss();
       String actualMsj=driver.findElement(By.xpath("//*[@id='result']")).getText();
       Assert.assertFalse(actualMsj.contains("successfuly"));
}
    @Test
    public void sendKeysAlert() throws InterruptedException {
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Zeynep");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.xpath("//*[text()='You entered: Zeynep']")).getText();
        Assert.assertTrue(actualResult.contains("Zeynep"));

    }


}
