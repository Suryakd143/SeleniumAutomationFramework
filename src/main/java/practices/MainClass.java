package practices;

public class MainClass {
    public static void main(String args[]){

        boolean isAnagram = true;

        String input1 = "abc";
        String input2 = "bac";

        char[] input1Chars = input1.toCharArray();
        char[] input2Chars = input2.toCharArray();

        if(input1Chars.length == input2Chars.length){
            for(int i=0; i<input1Chars.length ; i++){
                if (input1Chars[i] == input2Chars[i]){
                    System.out.println("Both Strings are not anagram.");
                    isAnagram = false;
                    return;
                }else{
                    continue;
                }
            }
            if(isAnagram){
                System.out.println("Both Strings are anagram.");
            }else{
                System.out.println("Both Strings are not anagram.");
            }
        }else{
            System.out.println("Not an anagram.");
        }

    }
}
