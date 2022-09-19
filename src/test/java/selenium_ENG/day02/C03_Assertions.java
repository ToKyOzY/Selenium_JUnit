package selenium_ENG.day02;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

    @Test
    public void assertions() {
        /*
        * Assertion is done to check if expected equals to action
        * Green checkmark-> PASS
        * yellow x -> fail
         */

        //Assert.assertEquals(4,5);
        Assert.assertEquals("apple","apple");
        Assert.assertEquals(false, false);
        //   Assert.assertTrue("Apple".equals("apple"));
        if ("Apple".equals("apple")){
//             VERIFICATION: if the statement fails, test case will continue execute
        }

        Assert.assertFalse("Apple".equals("apple"));//PASS
        Assert.assertTrue("apple".equals("apple"));//PASS

    }
}
