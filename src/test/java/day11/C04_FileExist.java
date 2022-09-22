package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));//Su an ki yolu verir: C:\com.Batch81Unit
        System.out.println(System.getProperty("user.home"));//gecerli kullanıcının ana dizinini verir: C:\Users\Zeynep Sar�kaya

        String farkliBolum=System.getProperty("user.home");
        //"C:\Users\Zeynep Sarıkaya\Desktop\text.txt" ---> masa ustundeki dosyanın yolu
        String ortakBolum="\\Desktop\\text.txt";

        String masaUstuDosyaYolu=farkliBolum+ortakBolum; //Masa ustundeki dosyanın yolunu gosterir

        System.out.println(masaUstuDosyaYolu);
        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));

        String dosyaYolu="C:\\Users\\Zeynep Sarıkaya\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web sitesinden indirdigimiz ya da window icinde ousturdugumuz
        dosyanın indigini ya da orda oldugunu test edebilmem icin o dosyanın üzerine shift tusuna basılı olarak sağclick
        yapıp dosyanınn yolunu kopyalayıp bir String degiskene atarız ve
        dosyayı dogrulamak icin Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız

         */

    }
}
