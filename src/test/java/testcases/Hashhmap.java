package testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Hashhmap {
    public static String Wordcount(String s) {
        //String s = "apple banana apple orange banana apple";
        String[] ss = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String hh: ss)
        {
            String reversedWord = "";
            for(int i=hh.length()-1;i>=0;i--)
            {
                reversedWord +=hh.charAt(i);
            }
            sb.append(reversedWord).append(" ");
            System.out.print(reversedWord);
        }
       return sb.toString().trim();


/*        TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
        for (String word : ss) {
            if (hm.containsKey(word)) {
                hm.put(word, hm.get(word) + 1);
            } else {
                hm.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
           System.out.println(entry.getKey() + " : " + entry.getValue());
            Integer charrr=entry.getValue();
            if(charrr==2)
            {
                System.out.print(entry.getKey());
                System.out.print("2");
            }
            else {
                for(int i=0;i<=charrr-1;i++)
                {
                    //System.out.print(entry.getKey());
                }
            }
        }
        return hm;*/
    }

    public static void main(String[] args) {
        String we ="apple banana apple orange banana apple";
        System.out.println(Wordcount(we));
    }
}
