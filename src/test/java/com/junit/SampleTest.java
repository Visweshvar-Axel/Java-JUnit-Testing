package com.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {
    @Test
    public void factTest1(){
        Sample sample = new Sample();
        int res = sample.fact(5);
        assertEquals(120,res);
    }
    @Test
    public void factTest2(){
        Sample sample = new Sample();
        int res = sample.fact(4 );
        assertEquals(24,res);
    }
}
