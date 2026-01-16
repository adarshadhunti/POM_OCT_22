package testcases;

public class ReverseWordsManual1 {

    public static String reverseEachWordManual(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length-1;i>=0;i--)
        {
            reversedSentence.append(words[i]).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String input = "Java is fun";
        String output = reverseEachWordManual(input);
        System.out.println("Original sentence: " + input);
        System.out.println("Reversed words: " + output);
    }
}

