import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {
    @Test
    void factTest1(){
        Sample sample = new Sample();
        int res = sample.fact(5);
        assertEquals(120,res,"the result should be 120 but wrong output: "+res);
    }
    @Test
    void factTest2(){
        Sample sample = new Sample();
        int res = sample.fact(4 );
        assertEquals(24,res,"the result should be 120 but wrong output: "+res);
    }
}
