package testcases;

public class ReverseWordsManual {

    public static String reverseEachWordManual(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (String word : words) {
            String reversedWord = "";
            // Loop through the word from the last character to the first
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord += word.charAt(i);
            }

            // Append the manually reversed word and a space
           reversedSentence.append(reversedWord).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String input = "Java is fun";
        String output = reverseEachWordManual(input);
        System.out.println("Original sentence: " + input);
        //System.out.println("Reversed words: " + output);
    }
}
