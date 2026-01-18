package javaoops;

public class program3 {
    public static void main(String[] args) {
        String input="java is fun";
        String[] ss= input.split(" ");
        StringBuilder ssb=new StringBuilder();
        for(int i= ss.length-1;i>=0;i--)
        {
            String reverse="";
            //System.out.print(ss[i]);
            for(int j=ss[i].length()-1;j>=0;j--)
            {
                reverse +=ss[i].charAt(j);

            }
                //System.out.println(reverse);
            ssb.append(reverse).append(" ");
        }
        System.out.println(ssb.toString().trim());
    }
}
