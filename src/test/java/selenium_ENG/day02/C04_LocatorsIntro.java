package selenium_ENG.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_LocatorsIntro {

    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://a.testaddressbook.com/sign_in");//going to the URL
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com"); //Locating the email input
        driver.findElement(By.id("session_password")).sendKeys("Test1234!"); //Locating the password input
        driver.findElement(By.name("commit")).click();

        // close the driver
        driver.quit();
    }

}
