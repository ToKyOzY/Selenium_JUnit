package day10;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test(){
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
       WebElement dragMe= driver.findElement(By.xpath("//*[@id='draggable']"));
       WebElement dropHere=driver.findElement(By.xpath("//*[@id='droppable']"));
       //Actions actions=new Actions(driver); ==>Extends yaptıgımız testbase class'da Actions olusturdugumuz için direkt objeyi burda kullandık
       actions.dragAndDrop(dragMe,dropHere).perform();
        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
