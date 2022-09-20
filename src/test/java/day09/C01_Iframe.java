package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //    ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //    ● Bir metod olusturun: iframeTest
        //       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());
        //       ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(textBox);
        WebElement textBoxFrame=driver.findElement(By.xpath("//p"));
        Thread.sleep(2000);
        textBoxFrame.clear();
        textBoxFrame.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);
        //       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //         dogrulayin ve konsolda yazdirin
        //driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

    }
}