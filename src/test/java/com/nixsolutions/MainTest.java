package com.nixsolutions;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(8, Main.add(3, 5));
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(10, Main.subtract(20, 10));
    }

}
