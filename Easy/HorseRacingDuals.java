import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] powers = new int[N]; //array storing all the horses' powers
        int d; //difference between two powers

        //storing the powers in an array
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            powers[i]=pi;
        }

        //sorting in ascending order
        Arrays.sort(powers);
        //by default
        d=powers[1]-powers[0];

        //iterating through the array to find the smallest difference
        for(int i=1; i<N-1;i++)
        {
            if (powers[i+1]-powers[i]<d)
                d=powers[i+1]-powers[i];
        }

        System.out.println(d);
    }
}
