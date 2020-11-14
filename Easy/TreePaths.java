import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Stack;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int M = in.nextInt();
        Stack<String> Spath = new Stack<String>();
        int[][] nodes = new int[M][3];
        String finalPath="";

        for (int i = 0; i < M; i++) {
            nodes[i][0]=in.nextInt();
            nodes[i][1]=in.nextInt();
            nodes[i][2]=in.nextInt();
        }

        if(V!=nodes[0][0])
        {
            do
            {
                for(int i = 0; i<nodes.length;i++)
                {
                    for(int j=0; j<3; j++)
                    {
                        if(V==nodes[i][j])
                        {
                            if(j==1) // if the node is on the left
                                Spath.push("Left");
                            else // right node
                                Spath.push("Right");
                            V=nodes[i][0]; // next step : look for the parent node
                        }
                    }
                }
            }
            while (V!=nodes[0][0]); //stepping out of the loop when the root has been reached

            while(!Spath.isEmpty()) //popping every element out of the stack and adding them in a String to form the final path in the right order
                finalPath = finalPath.concat(Spath.pop()+" ");
            finalPath=finalPath.substring(0,finalPath.length()-1); //deleting the last character (" ") of the string
        }
        else
            finalPath="Root";

        System.out.println(finalPath);
    }
}