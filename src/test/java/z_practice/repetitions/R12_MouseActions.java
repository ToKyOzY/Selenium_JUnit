package z_practice.repetitions;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;

public class R12_MouseActions extends TestBaseBeforeAfter {
    @Test
    public void test(){
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
        //mouse'u bu menunun ustune getirelim
        //3- "Create a list" butonuna basalim
        //4- Acilan sayfada "Your Lists" yazisi oldugunu test edelim
    }
}
