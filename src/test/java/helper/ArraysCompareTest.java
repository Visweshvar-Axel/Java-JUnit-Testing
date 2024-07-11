package helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    @BeforeClass
    public static void SetupBeforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public static void SetupAfterClass(){
        System.out.println("AfterClass");
    }
    @BeforeAll
    public static void SetupBeforeAll(){
        System.out.println("BeforeAll");
    }
    @AfterAll
    public static void SetupAfterAll(){
        System.out.println("AfterAll");
    }

    // Arrays.sort
    @Before
    public void Before(){
        System.out.println("Before");
    }
    @After
    public void After(){
        System.out.println("After");
    }
    @BeforeEach
    public void BeforeEach(){
        System.out.println("BeforeEach");
    }
    @AfterEach
    public void AfterEach(){
        System.out.println("AfterEach");
    }
    @Test
    public void testArraySort_RandomArray(){
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
//        int[] expected = {1,4,3,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
        // array contents differ at index [1], expected: <4> but was: <3>
    }
//    old version
//    @Test(expected=NullPointerException.class)
//    public void testArraySort_NullArray(){
//        int[] numbers = null;
//        Arrays.sort(numbers);
//    }
    @Test
    public void testArraySort_NullArray(){
        int[] numbers = null;
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            Arrays.sort(numbers);
        });
//        Arrays.sort(numbers);
        assertNotNull(exception);
    }
//    old version
//    @Test(timeout=1000)
//    public void testSort_Performance(){
//        int array[] = {12,23,4}
//        for (int i = 1; i < 1000000; i++) {
//            array[0] = i;
//            Arrays.sort(array);
//        }
//    }
    @Test
    public void testSort_Performance(){
        int array[] = {12,23,4};
        assertTimeout(java.time.Duration.ofMillis(1000),()->{
            for (int i = 1; i < 1000000; i++) {
                array[0] = i;
                Arrays.sort(array);
            }
        });
    }
    /* *
     * BeforeAll
     * BeforeEach
     * AfterEach
     * BeforeEach
     * AfterEach
     * BeforeEach
     * AfterEach
     * AfterAll
     * */
}
