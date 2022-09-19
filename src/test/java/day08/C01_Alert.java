package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.baggage.BaggageEntry;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alert {
    /*
    -https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    -Click for js Alert butonuna tıklayalım
    -tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim

     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test1() throws InterruptedException {
        //-Click for js Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //-tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());//uyarı yazısını yazdırmak istersek
        driver.switchTo().alert().accept();

    }
}
