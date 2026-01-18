package javaoops;

public class program1 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] words=input.split(" ");
        StringBuilder reverse=new StringBuilder();
        for(String rr: words)
        {
            String reverses="";
            for (int i=rr.length()-1;i>=0;i--)
            {
                reverses+=rr.charAt(i);
            }
            reverse.append(reverses).append(" ");
        }
        System.out.println(reverse.toString().trim());
    }
}
