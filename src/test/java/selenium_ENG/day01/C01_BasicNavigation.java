package selenium_ENG.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BasicNavigation {

        //Create main method
        //set path
        //creta chrome driver
        //Maximize window
        //Open google home page https://www.walmart.com/.NBSP
        //On the same class, Navigate to amazon home page https://www.amazon.com/
        //Navigate back to google
        //Navigate forward to amazon
        //Refresh the page
        //Close/Quit the browser

        public static void main(String[] args) throws InterruptedException {
            //Set driver and path
            System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
            //Create web driver object
            WebDriver driver=new ChromeDriver();

            driver.manage().window().maximize();//use to maximize the window size

            //start your test case
            driver.get("https://www.youtube.com/"); //get(URL) -> go to a URL

            Thread.sleep(3000); //wait for 3 seconds at this point

            //On the same class, Navigate to amazon home page https://www.amazon.com/
            driver.navigate().to("http://www.amazon.com");
            Thread.sleep(3000);

            //Navigate back to youtube
            driver.navigate().back();
            Thread.sleep(3000);

            //Navigate forward to amazon
            driver.navigate().forward();
            Thread.sleep(3000);

            //Refresh the page
            driver.navigate().refresh();

            //Close/Quit the browser
            driver.close();
            //or
            //driver.quit();

        /*
        1- What is the difference between get and navigate?
            Similarities : Both opens a pae url.
            Differences : 1. get() accepts the string url, navigate can be used with to()
                          2. get() connot be used to going back, forward, and refresh; navigate can be used for going back, forward and refresh
                          3. get() accept only string parameter; navigate accepts string ot url as paramater
         2- What is the difference between close and quit?
            1. close()-> closes only ACTIVE WORKING WINDOW
            2. quit()-> closes ALL working window

         */
        }
    }


