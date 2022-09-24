package day13;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        login();
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        table();
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
    }

    private void table() {
        /*
        Tabloda <Table> tag'ı altında tablonun başlıgını gösteren <Thead> tag'ı bulunur. Eger başlıkda satır varsa(row)
        Thead tag'ı altında <tr> (satır- row) tag'ı vardır ve başlıktaki sütunlara yani
        hucrelere (cell) de <th> tag'ı ile ulaşılır.
        Başlıgın altındaki tablodaki verilere <tbody>tag'ı ile altındaki satırlara (row) <tr> tag'ı ile hucrelere yani stunlara
        <td> tag'ı ile ulaşılır.
         */

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
      List<WebElement>tableSayisi= driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println(tableSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : "+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Body : "+body.getText());
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList=driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("tablodaki satir sayisi: "+satirList.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));
        //lambda 2. :
        driver.findElements(By.xpath("//tbody//tr")).stream().map(WebElement::getText).
                forEach(System.out::println);

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
