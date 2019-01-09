import javax.swing.*;

/**
 * Created by Daniil on 08.01.2019.
 */
public class MatchesCalculator {

    MatchesCalculator(String Input)
    {
        if (this.isAppropriateInput(Input))
        {
            int answer = calculateMinMatches(Double.parseDouble(Input));
            JOptionPane.showMessageDialog(null, "Minimal matches necessary \n for construction of " + Input +  "Square(-s) is:\n" +answer );

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Input doesn`t fullfill the requirenents\n 1<=Input<=10^(9) && Numeric! \n");
        }
    }


    public boolean isAppropriateInput(String InputString) //check input
    {
        try
        {
            long Input = Long.parseLong(InputString);
            if (Input <= Math.pow(10,9) && Input>=1)
            {
                return true;
            }
            else{return false;}
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }

    public int calculateMinMatches(double Input)
    {
        /* the optimal way is to construct large approximate square from the given number of 4-sides squares
         and to add the remains from one of the side. In Such way the optimal number of matches could be found:
             _ _ _ _ _ _ _ _ _ _
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|_|_|_|_|_|_|_|
            |_|_|_|
        */
        long length, width,result, remains;

        width = (int) Math.sqrt(Input);
        length =  (long)Input/width;
        result = width*(length+1) + length*(width+1); //Number of matches in large approcimae-square
        remains = (int)(Input) - width * length;
        if (remains>0)
        {
            result = result + 2*remains+1; // +remains of squares matches number
        }

        return (int)result;
    }


}
