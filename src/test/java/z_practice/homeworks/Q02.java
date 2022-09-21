package z_practice.homeworks;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q02 extends TestBaseBeforeAfter {
  @Test
    public void test1(){
      //a.web sayfasına gidin. https://www.amazon.com/
      driver.get("https://www.amazon.com");
      //b. Search(ara) “city bike”
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);
      //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
      System.out.println(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]")).getText());
      //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın
      driver.findElement(By.xpath("//*[@class='s-image'][1]")).click();
  }

}
