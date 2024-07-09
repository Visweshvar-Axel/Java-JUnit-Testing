package com.in28minutes.junit.helper;

public class Sample {
    public int fact(int num) {
        return (num==1)? num : num*fact(num-1);
    }
}
