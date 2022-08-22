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

    @Test
    public void testMultiply() {
        Assert.assertEquals(20, 2 * 10);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(10, 20 / 2);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        int result = 20 / 0;
    }

}
