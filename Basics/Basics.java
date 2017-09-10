import java.util.ArrayList;

public class Basics{
    public static void countTo(){
        for (int i = 0; i < 256; i++){
            System.out.println(i);
        }
    }
    public static void oddsOnly(){
        for (int i = 0; i < 256; i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }
    public static void countAndSum(){
        int sum = 0;
        for (int i = 0; i < 256; i++){
            sum += i;
            System.out.println("Current Number: " + Integer.toString(i) + " Current Sum: " + Integer.toString(sum));
        }
    }
    public static void iterateArray(int[] newArray){
        for (int runner : newArray){
            System.out.println(runner);
        }
    }
    public Integer findMax(int[] newArray){
        int max = newArray[0];
        for (int i = 1; i < newArray.length; i++){
            if (max < newArray[i]){
                max = newArray[i];
            }
        }
        return max;
    }
    public Integer findAvg(int[] newArray){
        int sum = 0;
        for (int i = 0; i < newArray.length; i++){
            sum += newArray[i];
        }
        return sum/newArray.length;
    }
    public Integer greaterThanY(int[] newArray, int y){
        int counter = 0;
        for (int runner : newArray){
            if (runner > y){
                counter++;
            }
        }
        return counter;
    }
    public int[] squareValues(int[] newArray){
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = (int) Math.pow(newArray[i], 2);
        }
        return newArray;
    }
    public int[] minMaxAvg(int[] newArray){
        int sum = 0;
        int max = newArray[0];
        int min = newArray[0];
        for (int i = 1; i < newArray.length; i++){
            if (min > newArray[i]){
                min = newArray[i];
            }
            if (max < newArray[i]){
                max = newArray[i];
            }
            sum += newArray[i];
        }
        int[] newerArray = {max, min, sum/newArray.length};
        return newerArray; 
    }
    public int[] shiftFront(int[] newArray){
        int length = newArray.length - 1;
            for (int i = 0; i < length; i++){
                newArray[i] =  newArray[i + 1];
            }
            newArray[length] = 0;
        return newArray;
    }
}