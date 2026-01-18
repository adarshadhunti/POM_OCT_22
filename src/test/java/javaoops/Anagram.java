package javaoops;

import java.util.Arrays; // Arrays.sort is an array utility, not a 'collection' in the list management sense

public class Anagram {

    // Function to check if two strings are anagrams
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(c1);
        Arrays.sort(c2);

        // Compare the sorted strings
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        int n = str.length;
        // Boolean array to keep track of strings already grouped
        boolean[] used = new boolean[n];
        System.out.println("Grouped Anagrams:");
        // Iterate through each string
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            // Start a new group with the current string
            System.out.print("[ " + str[i]);
            used[i] = true;
            // Compare with the remaining strings
            for (int j = i + 1; j < n; j++) {
                if (!used[j] && areAnagrams(str[i], str[j])) {
                    System.out.print(", " + str[j]);
                    used[j] = true;
                }
            }
            System.out.println(" ]");
        }
    }
}
