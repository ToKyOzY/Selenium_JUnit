package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;
    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown(){
        driver.quit();
    }
    @Before
    //Before notasyonu her tessten önce çalışır
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1(){
        //1 defa before methodu calisir
        driver.get("https://amazon.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method2(){
        //1 defa before methodu calisir
        driver.get("https://techproeducation.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method3(){
        //1 defa before methodu calisir
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }

}
