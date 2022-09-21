package z_practice.repetitions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class R05 extends R02_Utilities{

    @Test
    public void test1() throws InterruptedException {
        //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        WebElement cizgilialan=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgilialan).perform();
        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        Thread.sleep(2000);
        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));
        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String>  windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
    }
}
