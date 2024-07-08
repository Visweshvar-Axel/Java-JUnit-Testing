package com.junit;

public class Sample {
    public int fact(int num) {
        return (num==1)? num : num*fact(num-1);
    }
}
