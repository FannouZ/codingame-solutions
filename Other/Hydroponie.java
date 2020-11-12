import java.util.*;

public class Hydroponie {
    public static void main (String args[])
    {
        String grille = "5\n...x.\n.x...\nxx...\n.....\nx....";
        Scanner console = new Scanner(grille);

        int size= Integer.parseInt(console.nextLine());
        System.out.println("Taille: "+size);

        char[][] matrix= new char[size][size];


        String line="";

        for(int i =0;i<size;i++)
        {
            line = console.nextLine();
            for (int j=0;j<size;j++)
            {
                matrix[i][j]=line.charAt(j);
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println();
        }


        console.close();

        boolean test = Cultivable(matrix,4,4);
        System.out.println(test);


        int count=0;

        //scanning the matrix
        for(int i =0;i<size;i++)
        {
            for(int j =0;j<size;j++)
            {
                if (Cultivable(matrix,i,j)) //if the cell is cultivable, increment the counter
                    count++;
            }
        }
        System.out.println("number of cultivabe cells : " + count);
    }

    /**
     * indicates if a particular cell from a matrix is cultivable or not
     * @param mat the matrix which contains all the cell
     * @param indL line index of the cell
     * @param indC column index of the cell
     * @return true if the cell is cultivable, false if not
     */
    public static boolean Cultivable (char[][] mat, int indL, int indC)
    {
        boolean isCultiv=false;
        int startL=indL-1;
        int endL=indL+1;
        int startC=indC-1;
        int endC=indC+1;

        if(mat[indL][indC]!='x') //check if the cell is a humidity evaporator. if it is, we directly return false and do not check the cells around
        {
            if(indL==0) //first line
                startL=indL;
            if(indL==mat.length-1) //last line
                endL=indL;
            if(indC==0) 
                startC=indC; //first column
            if(indC==mat[0].length-1)
                endC=indC;

            for (int i = startL; i<=endL && !isCultiv;i++)
            {
                for (int j = startC; j<=endC && !isCultiv;j++)
                {
                    if(mat[i][j]=='x') //check if one of the cells around is an 'X'
                        isCultiv=true;
                }
            }
        }

        return isCultiv;
        
        
    }
}
