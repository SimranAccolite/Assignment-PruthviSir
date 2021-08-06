import java.util.ArrayList;
import java.util.Scanner;

public class WithoutThread
{
    static Scanner sc;
    static int Method1(ArrayList<String> inputs)
    {
        int count = 0;
        for (String sentence: inputs)
        {
            int len = sentence.split(" ").length;
            count += len;
        }
        return count;
    }

    static int Method2(ArrayList<String> inputs)
    {
        int count = 0;
        for (String sentence: inputs)
        {
            for(int i = 0; i< sentence.length(); i++)
            {
                if(sentence.charAt(i) == (' ')){
                    count += 1;
                }
            }
            count += 1;
        }
        return count;
    }

    public static void main(String[] args)
    {

        sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        long start1 = System.currentTimeMillis();
        ArrayList<String> inputs = new ArrayList<String>();
        for (int i = 0; i < n; i++)
        {
            String sentence = sc.nextLine();
            inputs.add(sentence);
        }

        int count1 = Method1(inputs);
        long end1 = System.currentTimeMillis();

        //long start2 = System.currentTimeMillis();
        //int count2 = Method2(inputs);
        //long end2 = System.currentTimeMillis();

        System.out.println("The count of words using First Method : "+count1);
        long elapsedTime1 = end1 - start1;
        System.out.println("Time taken for the code to execute using First Method:"+ elapsedTime1);
        //System.out.println("The count of words using Second Method : "+count2);
        //long elapsedTime2 = end2 - start2;
        //System.out.println("Time taken for the code to execute using Second Method:"+elapsedTime2);
    }
}