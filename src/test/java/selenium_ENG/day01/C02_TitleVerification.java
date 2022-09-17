package selenium_ENG.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_TitleVerification {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://www.techproeducation.com");

            //get title
            String actualTitle=driver.getTitle();
            String expectedTitle="Techpro Education | Online It Courses &amp; Bootcamps";

            //Verify if actualTitle= expectedTitle
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
                System.out.println("ACTUAL : "+actualTitle);
                System.out.println("EXPECTED : "+expectedTitle);


            /*
            driver.getTitle(); -> returns the page title
             */

            }
        }
    }


