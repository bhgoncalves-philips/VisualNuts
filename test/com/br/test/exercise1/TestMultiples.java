package com.br.test.exercise1;

import com.br.app.exercise1.Multiples;
import org.junit.Assert;
import org.junit.Test;

public class TestMultiples {
    @Test
    public void multipleOf3() {

        Assert.assertTrue(Multiples.isMultipleOf3(9));
    }

    @Test
    public void multipleOf5() {
        Assert.assertTrue(Multiples.isMultipleOf5(25));
    }

    @Test
    public void multipleOf15() {
        Assert.assertTrue(Multiples.isMultipleOf3(45) && Multiples.isMultipleOf3(45));
    }

    @Test
    public void notAMultiple() {
        Assert.assertFalse(Multiples.isMultipleOf5(17));
    }

}
