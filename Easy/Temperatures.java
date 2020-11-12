import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temperatures {

    public static void main(String args[]) {
        String enonce = "5\n6 10 -3 2 8";
        Scanner in = new Scanner(enonce);
        int n = Integer.parseInt(in.nextLine()); // the number of temperatures to analyse
        int nearest=0;

        if(n != 0)
        {
            String[] temps = in.nextLine().split(" ");
            nearest = Integer.parseInt(temps[0]);

            for (int i = 1; i < n; i++) {
            int t = Integer.parseInt(temps[i]); // a temperature expressed as an integer ranging from -273 to 5526
            if (Math.abs(t)<Math.abs(nearest))
                nearest=t;
            else if((Math.abs(t)==Math.abs(nearest)) && (t>nearest))
                nearest=t;            
                
            }
        }
        else
            nearest =0;

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(nearest);
        in.close();
    }
}