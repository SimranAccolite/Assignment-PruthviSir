/*
The program aims to calculate the sum of squares of even numbers and
sum of cubes of the odd numbers in the given range of numbers.
*/

import java.util.Scanner;

class CalSquare extends Thread{
    private int lowerLimit;
    private int upperLimit;
    private int total=0 ;

    CalSquare(int lowerLimit, int upperLimit)
    {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }
    public void run(){
        if(lowerLimit%2 != 0){
            lowerLimit += 1;
        }
        for (int i = lowerLimit; i <= upperLimit; i += 2) {
            this.total += i*i;
        }
        //return total;
    }

    public int getTotal() {
        return this.total;
    }
}

class CalCube extends Thread{
    private int lowerLimit;
    private int upperLimit;
    private int total = 0;
    CalCube(int lowerLimit,int upperLimit)
    {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public void run(){
        if(lowerLimit%2 == 0)
        {
            lowerLimit += 1;
        }
        for (int i = lowerLimit; i <= upperLimit; i += 2) {
            this.total += i*i*i;
        }
        //return total;
    }

    public int getTotal() {
        return this.total;
    }
}

public class SumCube{
    public static void main(String[] args)throws InterruptedException {
        System.out.println("****The program prints the sum of squares and cubes of given range of numbers");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lower limit and upper limit of the range");
        int lowerLimit = sc.nextInt();
        int upperLimit = sc.nextInt();
        CalCube calCube = new CalCube(lowerLimit,upperLimit);
        CalSquare calSquare= new CalSquare(lowerLimit,upperLimit);

        //Creating Threads
        calCube.start();
        calSquare.start();

        //Joining threads
        calCube.join();
        calSquare.join();
        //Calculation of the sum+-
        int total = calCube.getTotal() + calSquare.getTotal();
        System.out.println("The total sum of squares and cube of the given range of number is "+ total);
    }
}
