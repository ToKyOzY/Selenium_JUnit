package z_practice.homeworks;

import org.junit.Assert;
import org.junit.Test;
import z_practice.repetitions.R02_Utilities;

public class Q06 extends R02_Utilities {
    @Test
    public void test() throws InterruptedException {
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
            driver.get("https://www.youtube.com");
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        Assert.assertFalse(driver.getTitle().contains("youtube"));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com"));
        Thread.sleep(2000);

    }

}
