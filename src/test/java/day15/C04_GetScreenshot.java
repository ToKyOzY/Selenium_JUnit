package day15;

import day10_utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenshot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim tum sayfanın resmini alalım
        driver.get("https://www.amazon.com");

        /*
        Bir web sayfanın resmini alabilmek için TakeScreenShot class'ın obje oluşturup
        gecici bir File class'ından TakeScreenshot'dan oluşturdugum obje'den getScreenshotAs method'unu kullanarak gecici bir file oluştururuz
         */

        TakesScreenshot ts=(TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage.jpeg"+tarih+"jpeg"));

    }
}
