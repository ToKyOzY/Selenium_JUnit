package day16;

import day10_utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenshotWE extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //Arama sonucunun resmini alalım
        WebElement rusultSearch=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutallaAramaSonucu=rusultSearch.getScreenshotAs(OutputType.FILE);
        //Sadece WEbElementin resmini alcaksak TakeScreenShot class'ını kullanmama gerek yok
        //locate ettiğimiz webelementi direkt gecici bir file'a atıp FileUtils ile kopyalayıp yolunu(path) belirtiriz
        FileUtils.copyFile(nutallaAramaSonucu,new File("target/ekranGoruntusu/WebESS.jpeg"));

    }
}
