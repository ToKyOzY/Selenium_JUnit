package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test1() throws IOException {
        /*
        Belirtilen satırNo ve sutunNo degerlerini parametre olarak alıp o cell'deki datayı
        konsola yazdıralım
        sonra sonucun konsolda yazanla ynı oldugunu dogrulayalım.
         */
        int row=12;
        int cell=2;

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workBook= WorkbookFactory.create(fis);
        String actualData=workBook.getSheet("Sayfa1").
                getRow(row-1).
                getCell(cell-1).
                toString();
        System.out.println(actualData);
        Assert.assertEquals("Baku",actualData);
    }
}
