import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTest{
    public static void main(String[] args){
        int[] testArray = {3,5,1,2,7,9,8,13,25,32};
        String[] nameArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa", "Bob"};
        PuzzleJava puzzle = new PuzzleJava();
        System.out.println(puzzle.sumAndGreater(testArray));
        System.out.println(puzzle.shuffleNames(nameArray));
        puzzle.alphabetShuffle();
        ArrayList<Integer> d = puzzle.tenRandoms();
        System.out.println(d);
        ArrayList<Integer> e = puzzle.tenRandomsSorted();
        System.out.println(e);
        System.out.println(puzzle.randomString());
        String[] f = puzzle.randomStringArray();
        System.out.println(Arrays.toString(f));
    }
}