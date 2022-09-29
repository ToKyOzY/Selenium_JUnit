package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test1() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //  WorkbookFactory.create(fileInputStream)
        Workbook workBook= WorkbookFactory.create(fis);
        //sayfa2'ye gidip satir sayısının 15, kullanılan satır sayısının ise 4 oldugunu test edin
        int lastRow=workBook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(lastRow);
        Assert.assertEquals(15,lastRow+1);

        int kullanilanSatir=workBook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        //getPhysicalNumberOfRows() => Excel tablosunda kullanılan satır sayısını bu method ile alırız.
        System.out.println(kullanilanSatir);
        int expectedKullanilanSatir=4;
        Assert.assertEquals(expectedKullanilanSatir,kullanilanSatir);

    }
}
