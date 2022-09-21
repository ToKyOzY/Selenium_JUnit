package z_practice.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import z_practice.repetitions.R02_Utilities;

public class Q07 extends R02_Utilities {
    @Test
    public void test() throws InterruptedException {
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("400");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin - yazdırabilliriz de
        System.out.println(driver.findElement(By.xpath("//*[@id='alert_container']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='alert_container']")).isDisplayed());

    }

}
