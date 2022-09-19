package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;

public class C03_DropDown {
WebDriver driver;
Select select;
@Before
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("http://www.amazon.com");
}
@After
    public void tearDown(){
    //driver.quit();
}
@Test
    public void test1() {
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
    //oldugunu testedin
    WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    select=new Select(ddm);
    /*
    DropDown menuye ulaşmak için select classından bir obje oluştururuz
    Ve locate ettiğimiz dropdown Webelementini Select classına tanımlarız
    Ve getOption() method2unu kullanarak dropdown'u bir liste atarak dropdown menunu bütün elemanlarının sayısına ulaşırız
     */
    List<WebElement> ddmList=select.getOptions();
    System.out.println(ddmList.size());
    int expectedNumber=45;
    int actualNumber=ddmList.size();
    Assert.assertNotEquals(expectedNumber,actualNumber);
}
@Test
    public void test2() {
    //           1.Kategori menusunden Books seceneginisecin
    WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    select=new Select(ddm);
    select.selectByVisibleText("Books");//eger dropdown menudeki option'a string olarak ulaşmak istersek
    select.selectByIndex(5);//eger ddm'sunun index'i ile ulaşmak istersek
    System.out.println(select.getFirstSelectedOption().getText());// eger ddm'ndeki option'a value ile ulaşmak istersek bu methodu kullanırız
    /*
    Dropdown menude sectigimiz option'a ulaşmak istersek select.getFirstSelectedOption()
    methodunu kullanırız
     */

    //           2.Arama kutusuna Java yazin vearatin
  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
    //           3.Bulunan sonuc sayisiniyazdirin
    WebElement sonuc=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
    System.out.println(sonuc.getText());
    List<WebElement> result=driver.findElements(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
    System.out.println(result.stream().findFirst().get().getText().split(" ")[3]);
    //           4.Sonucun Java kelimesini icerdigini testedin
    String actualWord=sonuc.getText();
    Assert.assertFalse(actualWord.contains("Java"));




}
}
