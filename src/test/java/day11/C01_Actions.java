package day11;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C01_Actions extends TestBaseBeforeAfter {


    @Test
    public void test1() {
        //
        driver.get("https://amazon.com");
        //Arama kutusuna actions methodlarını kullanarak samsung A71 yazdırın
        //ve enter'a basarak arma yaptırın
        WebElement box=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        actions.click(box).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).
                perform();
        //aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }
}
