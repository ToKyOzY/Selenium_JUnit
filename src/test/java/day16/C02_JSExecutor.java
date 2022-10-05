package day16;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //Aşagıdaki carrers butonunu görünceye kadar Js ile scroll yaplım
        WebElement carrers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);
        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrers);

    }
}
