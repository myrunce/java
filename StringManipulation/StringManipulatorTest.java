public class StringManipulatorTest{
    public static void main(String[] args){
    StringManipulator changeString = new StringManipulator();
    String str = changeString.trimAndConcat("    Hello     ","     World    ");
    System.out.println(str);
    char letter = 'o';
    Integer a = changeString.getIndexOrNull("Coding", letter);
    Integer b = changeString.getIndexOrNull("Hello World", letter);
    Integer c = changeString.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null  
    }
}