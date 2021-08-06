import java.util.ArrayList;
import java.util.Scanner;

class CountWords extends Thread{
    private int start;
    private int val;
    private ArrayList<String> inputs;
    private int count = 0;

    CountWords(int start,ArrayList<String> inputs, int val )
    {
        this.start =start;
        this.inputs = inputs;
        this.val = val;
    }

    public int getStart() {
        return start;
    }

    public int getVal() {
        return val;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = start; i < val; i++) {
            for (int j = 0; j < inputs.get(i).length(); j++) {
                if (inputs.get(i).charAt(j) == (' ')) {
                    count += 1;
                }
            }
            count += 1;
        }
    }
}


public class ThreadString{
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> inputs = new ArrayList<String>();
        for (int i = 0; i < n; i++)
        {
            String sentence = sc.nextLine();
            inputs.add(sentence);
        }

        // no. of threads
        System.out.println("Input NUmber of Threads");
        int m = sc.nextInt();
        long start1 = System.currentTimeMillis();
        int val = n/m;
        ArrayList<CountWords> th = new ArrayList<>();
        int i =0;
        int check = 0;
        while(check != m){
            if (i == 0) {
                CountWords countWords = new CountWords(i, inputs, val);
                th.add(countWords);
            }
            else if(i == m-1)
            {
                CountWords countWords = new CountWords(i, inputs, n);
                th.add(countWords);
            }
            else{
                CountWords countWords = new CountWords(i, inputs, i +val);
                th.add(countWords);
            }
             i += val;
            check++;
        }
        for(CountWords words: th){
            words.start();
            //System.out.println(words.getVal()+" "+ words.getStart());
        }

        for(CountWords words: th){
            words.join();
            //System.out.println(words.getVal()+" "+ words.getStart());
        }

        int totalCount = 0;
        for(CountWords words: th) {
            totalCount += words.getCount();

        }
        long end1 = System.currentTimeMillis();
        System.out.println("Total number of words in the String input is:"+ totalCount);
        long elapsedTime1 = end1 - start1;
        System.out.println("Time taken for the code to execute using Threads is:"+ elapsedTime1);
    }
}
