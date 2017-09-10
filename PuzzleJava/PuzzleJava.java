import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    public ArrayList<Integer> sumAndGreater(int[] array){
        int sum = 0;
        ArrayList<Integer> greaterThan = new ArrayList<Integer>();
        for (int add : array){
            sum += add;
            if (add > 10){
                greaterThan.add(add);
            }
        }
        System.out.println(sum);
        return greaterThan;
    }

    public ArrayList<String> shuffleNames(String[] array){
        ArrayList<String> allNames = new ArrayList<String>(Arrays.asList(array));
        ArrayList<String> longNames = new ArrayList<String>();
        Collections.shuffle(allNames);
        for (String val : allNames){
            System.out.println(val);
            int lengthOfString = val.length();
            if (lengthOfString > 5){
                longNames.add(val);
            }
        }
        return longNames;
    }

    public static void alphabetShuffle(){
        String[] alaphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] vowels = {"a", "e", "i", "o", "u"};
        ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList(alaphabet));
        ArrayList<String> listVowels = new ArrayList<String>(Arrays.asList(vowels));
        Collections.shuffle(alphabetList);
        String first = alphabetList.get(0);
        String last = alphabetList.get(alphabetList.size() - 1);
        if(Arrays.asList(vowels).contains(first)) {
			System.out.println("The first letter is a vowel!");
		}
		System.out.println(first);
		System.out.println(last);
    }

    public ArrayList<Integer> tenRandoms(){
        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            resultArray.add(r.nextInt(101 - 55) + 55);
        }
        return resultArray;
    }

    public ArrayList<Integer> tenRandomsSorted(){
        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            resultArray.add(r.nextInt(101 - 55) + 55);
        }
        Collections.sort(resultArray);
        System.out.println(resultArray.get(0));
        System.out.println(resultArray.get(resultArray.size() - 1));
        return resultArray;
    }

    public String randomString(){
        String[] alaphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList(alaphabet));
        Collections.shuffle(alphabetList);
        String first = alphabetList.get(0);
        String second = alphabetList.get(1);
        String third = alphabetList.get(2);
        String fourth = alphabetList.get(3);
        String fifth = alphabetList.get(4);
        String randomString = first + second + third + fourth + fifth;
        return randomString;
    }

    public String[] randomStringArray(){
        String[] alaphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList(alaphabet));
        String[] randomStringArray = new String[10];
        for (int i = 0; i < 10; i++){
            Collections.shuffle(alphabetList);
            String first = alphabetList.get(0);
            String second = alphabetList.get(1);
            String third = alphabetList.get(2);
            String fourth = alphabetList.get(3);
            String fifth = alphabetList.get(4);
            String randomString = first + second + third + fourth + fifth;
            randomStringArray[i] = randomString;
        }
        return randomStringArray;
    }
}