package day10;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test() {
        driver.get("http://amazon.com");

    }
}
