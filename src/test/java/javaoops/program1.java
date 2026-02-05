package javaoops;

public class program1 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] words=input.split(" ");
        StringBuilder reverse=new StringBuilder();
        for(String rr: words)
        {
            StringBuilder reverses= new StringBuilder();
            for (int i=rr.length()-1;i>=0;i--)
            {
                reverses.append(rr.charAt(i));
            }
            reverse.append(reverses).append("%");
         }
        reverse.deleteCharAt(reverse.length()-1);
        String finaloutput=reverse.toString().trim();
        System.out.println(finaloutput);
    }
}
