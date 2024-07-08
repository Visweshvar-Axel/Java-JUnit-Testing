package com.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickBeforeAfterTest {
    StringHelper helper;
    @BeforeEach
    public void setup(){
        System.out.println("Before test");
        helper = new StringHelper();
    }
    @AfterEach
    public void teardown() {
        System.out.println("After test");
        helper = null;
    }
    @Test
    public void test1(){
        System.out.println("test1 executed");
    }
    @Test
    public void test2(){
        System.out.println("test2 executed");
    }
}
