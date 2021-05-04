package ru.aftlessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void test1() {
        Primes prime = new Primes();
        Assert.assertTrue(prime.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void test2() {
        Primes prime = new Primes();
        Assert.assertFalse(prime.isPrime(Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void test3() {
        Primes prime = new Primes();
        Assert.assertTrue(prime.isPrime((long)Integer.MAX_VALUE));
    }

    @Test
    public void test4() {
        Primes prime = new Primes();
        Assert.assertTrue(prime.isPrimeFast(Integer.MAX_VALUE));
    }

}
