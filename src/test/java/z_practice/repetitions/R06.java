package z_practice.repetitions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class R06 extends R02_Utilities{

    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        //Account menusunden create e list linkine tıklayalım

        driver.get("https://amazon.com");
        WebElement accountList= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
