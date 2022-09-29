package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test1() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//oluşturmuş oldugumuz dosyayı sistemde işleme alır.
        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //  WorkbookFactory.create(fileInputStream)
        Workbook workBook= WorkbookFactory.create(fis);//Workbook objesi ile fis objesiyle akışa aldıgımız dosyamızdan bir excel dosyası create ettik.
        //  Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workBook.getSheet("Sayfa1");//Excelde çalışmak istedigimiz sayfayı bu sekilde seceriz.
        //  Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);//sayfa 1 deki 3. satiri bu sekilde seceriz.
        //  Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);//satir seçimi yapıldıktan sonra hücre secimi  bu şekilde yapılır.
        System.out.println(cell);
        // ^. index'deki satirin 3. inedex'indeki datanin Cezayir oldugunu test edin.
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData, actualData);
        //veya
        Assert.assertEquals("Cezayir",cell.getStringCellValue());

    }
}
