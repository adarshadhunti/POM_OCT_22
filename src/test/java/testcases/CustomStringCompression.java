package testcases;


public class CustomStringCompression {

    public static void main(String[] args) {
        String input = "aaabbccccdd";
        String output = compressString(input);
        System.out.println("Input: " + input + " ");
        System.out.println("Output: " + output + " ");
    }

    public static String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        int n = input.length();
        int count=1;
        for (int i=1;i<=n;i++)
        {
            if (i<n && input.charAt(i)==input.charAt(i-1))
            {
                count++;
            }
            else
            {
                char c=input.charAt(i-1);

                if(count ==2)
                {
                    compressed.append(c).append(2);
                }
                else {
                    for (int j=0;j<count;j++)
                    {
                        compressed.append(c);
                    }
                }
                System.out.println(c+": count is "+ count);
                count=1;
            }
        }
        return compressed.toString();
        //hel
        //Hello World
        //ramu
        //raju
    }
}
