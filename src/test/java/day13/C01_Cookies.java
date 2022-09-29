package day13;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //-tum cookie’leri listeleyin
        Set<Cookie> allCookie = driver.manage().getCookies();
        System.out.println(allCookie);
        int sayac = 1;
        for (Cookie w : allCookie
        ) {
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". name: " + w.getName());
            System.out.println(sayac + ". value: " + w.getValue());
            sayac++;
        }

        //lambda ile
        allCookie.stream().forEach(t -> System.out.println("name : " + t.getName() + " value :" + t.getValue()));

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(allCookie.size() > 5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : allCookie
        ) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }
        }
        //lambda ile
        allCookie.stream().filter(t -> t.getName().equals("i18n-prefs")).
                forEach(t -> Assert.assertEquals("USD", t.getValue()));
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        allCookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w : allCookie
        ) {
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". name: " + w.getName());
            System.out.println(sayac + ". value: " + w.getValue());
            sayac++;
        }
            //6-eklediginiz cookie’nin sayfaya eklendigini test edin
            Assert.assertFalse(allCookie.contains(yeniCookie));
            //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        allCookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w : allCookie
        ) {
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". name: " + w.getName());
            System.out.println(sayac + ". value: " + w.getValue());
            sayac++;
        }
        Cookie isim=driver.manage().getCookieNamed("skin");
        Assert.assertTrue(!allCookie.contains(isim));
            //8-tum cookie’leri silin ve silindigini test edin
            driver.manage().deleteAllCookies();
            allCookie=driver.manage().getCookies();
            Assert.assertTrue(allCookie.isEmpty());
        }
    }

