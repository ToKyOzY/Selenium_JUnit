package selenium_ENG.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_URLverification {

        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.get("http://www.techproeducation.com");
            driver.manage().window().maximize();
            String actualUrl=driver.getCurrentUrl();
            String expectedUrl="http://www.techproeducation.com";

            //verify
            if (actualUrl.equals(expectedUrl)) {
                System.out.println("PASS");
            }else System.out.println("FAIL");
            System.out.println("ACTUAL URL is "+actualUrl );
            System.out.println("EXPECPED URL is "+expectedUrl);

            driver.quit();
        }

    }


