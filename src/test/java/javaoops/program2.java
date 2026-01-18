package javaoops;

public class program2 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] ss=input.split(" ");
        StringBuilder sss= new StringBuilder();

        for (int i=ss.length-1;i>=0;i--)
        {
            sss.append(ss[i]).append(" ");
        }
        String output=sss.toString().trim();
         System.out.println(output);
    }
}
