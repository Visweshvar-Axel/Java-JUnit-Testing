package com.junit;

import org.junit.jupiter.api.*;

public class QuickBeforeAfterTest {
    StringHelper helper;
    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before class");
        // if needed only for optimization
    }
    @AfterAll
    public static void afterClass(){
        System.out.println("After class");
    }
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
