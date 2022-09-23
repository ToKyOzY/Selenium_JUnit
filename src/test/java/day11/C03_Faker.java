package day11;

import com.github.javafaker.Faker;
import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1-"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //2-"create new account"  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3-"firstName" giris kutusuna bir isim yazin
        //4-"surname" giris kutusuna bir soyisim yazin
        //5-"email" giris kutusuna bir email yazin
        //6-"email" onay kutusuna emaili tekrar yazin
        //7-Bir sifre girin
        //8-Tarih icin gun secin
        //9-Tarih icin ay secin
        //10-Tarih icin yil secin
        //11-Cinsiyeti secin
        //12-Kaydol butonuna basın
        //13-Sayfayi kapatin
        WebElement isim= driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        String email=faker.internet().emailAddress(); // aynı mail adresi girmesi icin String bir değişkene atma yaptık
        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerinde defalarca kendi
        üretecegimiz veriler yerine bizim icin random veriler üretir ve işimizi kolaylaştırır..

        Faker classını kullanmak icin mvnrepository.com adresinden Jaa-faker kütüphanesini aratır ve
        en cok kullanılanı pom.xml dosyasına ekleriz. Ve faker classından bir obje olusturup
        email cin faker.internet() methodunu kullanarak mailadress() methodunu seceriz
        password içinde aynı internet methodunu kullanırız
        isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("8").sendKeys(Keys.TAB).
                sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("1985").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.LEFT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


    }
}
