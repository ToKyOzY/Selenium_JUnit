package day13;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static sun.security.jgss.GSSUtil.login;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //bir önceki class'daki adrese gidelim
        //Login() methodunu kullanrak sayfaya giris yapalım
        login();
        int row=3;
        int sutun=4;
        //input olarak verilen saatır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        WebElement cell= driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutundaki text: "+cell.getText());
        //Price başlığındaki tum numaraları yazdırınız
        List<WebElement> priceTitle=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:priceTitle) {
            System.out.println(w.getText());
        }

    }
       /*
Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
sutunlara yani hucrelere<td> tag'i ile ulasilir.
 */



    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
