package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test1() throws IOException {
        //1)Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String doyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(doyaYolu);
        Workbook workBook= WorkbookFactory.create(fis);
        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workBook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workBook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workBook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workBook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");
        //9)Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(doyaYolu);//
        //10)Dosyayi kapatalim
    }
}
