package ru.aftlessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EqationTests {

    @Test
    public void test0() {
        Equation eq = new Equation(1, 1, 1);
        Assert.assertEquals(eq.getN(), 0);
    }
    @Test
    public void test1() {
        Equation eq = new Equation(1, 2, 1);
        Assert.assertEquals(eq.getN(), 1);
    }
    @Test
    public void test2() {
        Equation eq = new Equation(1, 4, 2);
        Assert.assertEquals(eq.getN(), 2);
    }


}
