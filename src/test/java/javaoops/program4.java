package javaoops;

import java.util.ArrayList;

public class program4 {
    public static void main(String[] args) {
        String input = "aaabbcccdd";
        ArrayList<String> ll = new ArrayList<String>();
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= input.length(); i++) {
            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count == 2) {
                    System.out.print(input.charAt(i - 1));
                    System.out.print("2");
                } else {
                    for (int k = 0; k < count; k++)
                        System.out.print(input.charAt(i - 1));
                }
                count = 1;
            }
        }
    }
}
