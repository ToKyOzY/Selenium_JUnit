package day10_utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeAfter {
    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;
    protected String tarih;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);
        faker=new Faker();
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(formater);

    }
    @After
    public void tearDown() {
       // driver.quit();
    }
}

  
