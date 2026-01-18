package javaoops;

public class program3 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] ss=input.split(" ");
        StringBuilder sb=new StringBuilder();

        for (int i= ss.length-1;i>=0;i--)
        {
            String reverse= "";
         for (int j=ss[i].length()-1;j>=0;j--)
         {
             reverse +=ss[i].charAt(j);
         }
         sb.append(reverse).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
