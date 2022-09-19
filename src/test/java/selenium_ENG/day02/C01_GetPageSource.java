package selenium_ENG.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetPageSource {

        WebDriver driver;
        @Before
        public void setup() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("http://amazon.com");
        }
        @Test
        public void test(){
            driver.getPageSource();//getPageSource(); returns the page source as String

            Assert.assertTrue((driver.getPageSource()).contains("Registry"));
        }
    }


