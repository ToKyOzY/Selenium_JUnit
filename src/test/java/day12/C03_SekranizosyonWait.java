package day12;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_SekranizosyonWait extends TestBaseBeforeAfter {
    @Test
    public void imlicitlyWaitTest1() {
        //Bir class olusturun : WaitTest
        //Iki tane metod olusturun : implicitWait() , explicitWait()
                  /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue( driver.findElement(By.xpath(" //*[@id='message']")).isDisplayed());
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[@type='button'][1]")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());
    }

    @Test
    public void explicitWaitTest2() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement itsGoneWe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='message']")));
        Assert.assertTrue( itsGoneWe.isDisplayed());
        /*
        explicitWait itsGoneWe görünür olmasını beklerken o web elementinin locate'ini kullanarak assert yapmak
        sorun olur ve exception fırlatır. Henuz gorulmeyen bir web elementin locate edilmesi de
        otomasyon icin mumkun olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız.
         */
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[@type='button'][1]")).click();

        //It’s back mesajinin gorundugunu test edin
        WebElement itsBack= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}
