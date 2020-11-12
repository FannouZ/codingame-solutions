import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    /**
     * 
     * @param clawPos : current position of the claw
     * @param boxes : array of integers that represent the number of boxes for each stack
     * @param boxInClaw : true if the claw is holding a box, false otherwise
     * @return
     */
    public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
        /** STEPS :
         * count the total number of boxes
         * create a second array which will represent the final solution
         * compare the two arrays to decide what action to do
         */
        String move="";

        //count the total number of boxes
        int nbBoxes=0;
        for(int i =0; i<boxes.length;i++)
            nbBoxes += boxes[i];
        if (boxInClaw) //if the claw is holding a box, we have to count it as well
            nbBoxes++;
            
        //initialize the array which represents the desired stacks
        int[] result = new int[boxes.length];
        for(int i =0; i<boxes.length;i++)
            result[i]=0;
        int ind=0;
        //fill the array
        while(nbBoxes>0)
        {
            result[ind] +=1;
            nbBoxes--;
            ind = (ind==result.length-1) ? 0 : (ind+1);
        }        

        //movement decision :
        if (boxes[clawPos]>result[clawPos] && !boxInClaw) //pick if there are two many boxes on the stakc and claw is empty
            move="PICK";
        else if (boxes[clawPos]<result[clawPos] && boxInClaw) // place if there is at least one missing box on the stack and claw is full
            move="PLACE";
        else //includes the case where there is the right amount of boxes on the position clawPos
        {
            int dest=boxes.length-1; //destination of the claw, by default the far right
            for(int i =0; i<boxes.length;i++) //iterate to find where the claw should go next
            {
                if (!boxInClaw && result[i]<boxes[i]) //if claw empty, we have to find a stack where there are too many boxes
                    dest=i;
                if (boxInClaw && result[i]>boxes[i]) //is claw full, we have to find a stack where there is a missing box
                    dest=i;
            }
            move = (dest<clawPos) ? "LEFT" :"RIGHT";
        }
        


        return move;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int clawPos = in.nextInt();
            boolean boxInClaw = in.nextInt() != 0;
            int stacks = in.nextInt();
            int[] boxes = new int[stacks];
            for (int i = 0; i < stacks; i++) {
                boxes[i] = in.nextInt();
            }
            PrintStream outStream = System.out;
            System.setOut(System.err);
            String action = solve(clawPos, boxes, boxInClaw);
            System.setOut(outStream);
            System.out.println(action);
        }
    }
    // #endregion
}