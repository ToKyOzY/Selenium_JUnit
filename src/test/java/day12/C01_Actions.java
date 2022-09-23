package day12;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        //Automationexercise.com sitesine gidelim product bolumune girelim ilk urune tiklayalim

        driver.get("https://automationexercise.com");
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();

    }
}
