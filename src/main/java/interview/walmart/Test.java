package interview.walmart;

public class Test {
    public static void main(String[] args) {


    }

    public int shipWithinDays(int[] weights,int days)
    {
        int maxWeight = 0;
        for (int i:weights)
        {
           maxWeight=Math.max(maxWeight,i);
        }

       while (!distribute(1,0,maxWeight,weights,days))
       {
           ++maxWeight;
       }
       return maxWeight;
    }

    public static boolean distribute(int day,int startIndex,int weight,int[] weights,int days)
    {
        if (day<=days)
        {
            int dayTotal = 0 ;
            for (int i = startIndex ; i<weights.length;i++)
            {
                dayTotal+=weights[i];
                if (dayTotal>weight)
                {
                    break;
                }
                else
                {
                    startIndex++;
                }
            }
            return distribute(++day,startIndex,weight,weights,days);
        }
        else{
            return startIndex==weights.length;
        }
    }

    public static boolean distribute1(int day,int startIndex,int weight,int[] weights,int days)
    {
        if (day<=days)
        {
            int dayTotal = 0 ;
            for (int i = startIndex ; i<weights.length;i++)
            {
                dayTotal+=weights[i];
                if (dayTotal>weight)
                {
                    break;
                }
                else
                {
                    startIndex++;
                }
            }
            return distribute(++day,startIndex,weight,weights,days);
        }
        else{
            return startIndex==weights.length;
        }

    }
}
