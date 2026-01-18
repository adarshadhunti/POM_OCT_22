package javaoops;

public class program1 {
    public static void main(String[] args) {
        String input="Java is fun";
        StringBuilder sb=new StringBuilder();
        String[] ss= input.split(" ");

        for (String gh: ss)
        {
            String reversed="";
            for (int i=gh.length()-1; i>=0;i--)
            {
                reversed +=gh.charAt(i);
            }
            sb=sb.append(reversed).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
