package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @Test
    public void test1(){
        //https://html.com/tags/iframe/ adresine gidiniz
        //YouTube videosunu çalıştırınız
        driver.get("https://html.com/tags/iframe/");
        /*
        Bir web sitesinde bir video(youtube vb) varsa <iframe> tag'ı içerisindeyse bu videoyu direkt locate edip çalıştırmak
        dinamik ollmaz çünkü link değişebilir ve locateimiz çlaışmaz.
        Bunun icin butun frameleri bir array liste atıp ndex ile frame'ii secip sonrasında play tuşunu locate edip çalıştırabiliriz.
         */
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();


    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
