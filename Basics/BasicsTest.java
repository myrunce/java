import java.util.Arrays;

public class BasicsTest{
    public static void main(String[] args){
        int[] testArray = {3,5,1,4,2};
        Basics testJava = new Basics();
        testJava.countTo();
        testJava.oddsOnly();
        testJava.countAndSum();
        testJava.iterateArray(testArray);
        Integer a = testJava.findMax(testArray);
        System.out.println(a);
        Integer b = testJava.findAvg(testArray);
        System.out.println(b);
        Integer c = testJava.greaterThanY(testArray, 7);
        System.out.println(c);
        int[] d = testJava.squareValues(testArray);
        System.out.println(Arrays.toString(d));
        int[] e = testJava.minMaxAvg(testArray);
        System.out.println(Arrays.toString(e));
        int[] f = testJava.shiftFront(testArray);
        System.out.println(Arrays.toString(f));
    }
}