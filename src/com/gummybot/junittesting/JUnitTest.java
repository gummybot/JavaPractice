package com.gummybot.junittesting;


import com.gummybot.recursion.ClassFibonacci;
import org.junit.*;

public class JUnitTest {
    @Test
    public void test_fibonacci() {
        ClassFibonacci fib = new ClassFibonacci();
        Assert.assertEquals(2,fib.fibonacci(3));
    }

}
