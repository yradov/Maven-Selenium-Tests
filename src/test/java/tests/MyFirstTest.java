package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void firstTest() {
        Assert.assertEquals(1, 1);
    }
}
