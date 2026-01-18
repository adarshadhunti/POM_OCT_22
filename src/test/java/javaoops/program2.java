package javaoops;

public class program2 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] ss= input.split(" ");
        StringBuilder reversedstring=new StringBuilder();
        for(int i= ss.length-1;i>=0;i--)
        {
            reversedstring.append(ss[i]).append(" ");
            //hello
        }
        System.out.println(reversedstring.toString().trim());
    }
}
