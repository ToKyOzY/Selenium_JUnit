package z_practice.repetitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class R02_Utilities {
  protected   WebDriver driver;
  protected Actions actions;
  @Before
    public void setup() {
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      actions=new Actions(driver);

  }

  @After
    public void tearDown() {
      //driver.quit();
  }
}
