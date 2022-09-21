package day10;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class C03_Action extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //Amazon sayfasına gidelim
        //Account menusunden create a list menusunu tıklayalım
        driver.get("http://amazon.com");
        WebElement accountList=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        /*
        Bir Web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullnmamız gerekir. Aksi takdirde
        html kodları arasında Web elementi bulur ama ulaşamdıgı için ElementNoInterctableException: Element no interactable
        exception'ı fırlatır
         */

    }
}
