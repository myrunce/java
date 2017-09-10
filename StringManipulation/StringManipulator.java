public class StringManipulator{
    public String trimAndConcat(String str1, String str2){
        String s1 = str1.trim();
        String s2 = str2.trim();
        String newString = s1.concat(s2);
        return newString;
    }
    public Integer getIndexOrNull(String str1, char char1){
        Integer indexOfStr = str1.indexOf(char1);
        if (indexOfStr == -1){
            return null;
        }
        else{
            return indexOfStr;
        }
    }
}