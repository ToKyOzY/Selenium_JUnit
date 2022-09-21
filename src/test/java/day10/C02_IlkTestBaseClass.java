package day10;

import day10_utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test() {
        driver.get("http://amazon.com");
    }
}
