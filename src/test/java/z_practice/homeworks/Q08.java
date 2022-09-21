package z_practice.homeworks;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q08 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws Exception {
        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        //b. Locate email textbox
        //c. Locate password textbox ve
        //d. Locate signin button
        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.cssSelector("input#session_password")).sendKeys("Test1234!");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        //NOT: cssSelector kullanarak elementleri locate ediniz
    }


}
