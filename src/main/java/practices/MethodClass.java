package practices;

public class MethodClass {
    public static String reverseString(String stringToReverse){
        char[] charArray = stringToReverse.toCharArray();
        int count = charArray.length;
        char[] resultArray = new char[count];

        for(char character:charArray) {
            resultArray[count-1] = character;
            count--;
        }
        String result = String.valueOf(resultArray);
        System.out.println(result);
        return result;
    }
}
