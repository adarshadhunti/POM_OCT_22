package javaoops;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Anagrams {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, HashSet<String>> anagramGroups = new HashMap<>();

        for (String word : str) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramGroups.putIfAbsent(sortedStr, new HashSet<>());
            anagramGroups.get(sortedStr).add(word);
        }

        System.out.println("Anagram groups:");
        for (HashSet<String> group : anagramGroups.values()) {
            System.out.println(group);
        }
        /*System.out.println(anagramGroups.values());*/
        //SIMPLE1
    }
}
