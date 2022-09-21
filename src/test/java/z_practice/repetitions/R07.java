package z_practice.repetitions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class R07 extends R02_Utilities{
    @Test
    public void test1() throws InterruptedException {
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere= driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        Thread.sleep(2000);
        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
