package z_practice.homeworks;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 extends TestBaseBeforeAfter {
@Test
    public void test1() throws InterruptedException {
    //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
     driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    //2- Add Element butonuna basin
    driver.findElement(By.xpath("//*[text()='Add Element']")).click();
    Thread.sleep(2000);
    //3 Delete butonu’nun gorunur oldugunu test edin
    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Delete']")).isDisplayed());
    //4 Delete tusuna basin
    driver.findElement(By.xpath("//*[text()='Delete']")).click();
    //5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
    Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
}

    }


