package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_DropDownHandle {
   WebDriver driver;
   @Before
    public void ssetUp() {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.amazon.com/");
   }
   @After
    public void tearDown() {
       //driver.quit();
   }
   @Test
    public void test1() {
       //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
       //oldugunu testedin
       List<WebElement> drops=driver.findElements(By.xpath("//option"));
       System.out.println(drops.size());
       for (WebElement w:drops
            ) {
           System.out.println(w.getText());
       }
        int dropDownList=drops.size();
        int expectedSayi=45;
        Assert.assertNotEquals(expectedSayi,dropDownList);
   }

    @Test
    public void test2() {
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
        //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisiniyazdirin
        WebElement result= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());
        //--sadece sayıyı yazdır
        List<WebElement> result2=driver.findElements(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result2.stream().findFirst().get().getText().split(" ")[3]);
        //4.Sonucun Java kelimesini icerdigini testedin
        String resultWriter=result.getText();
        Assert.assertTrue(resultWriter.contains("Java"));
    }



}
