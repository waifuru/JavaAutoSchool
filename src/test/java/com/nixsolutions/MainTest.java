package com.nixsolutions;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(8, Main.add(3, 5));
    }

}
