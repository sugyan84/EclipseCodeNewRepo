package problem.compete.Beer;


import java.io.ObjectOutputStream;
import java.util.*;


class TestClass 
{
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        //BufferedReader
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT */

        //Scanner
        
        Scanner s = new Scanner(System.in);
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        

        // Write your code here
        int T = s.nextInt();
        
        double sum = 0;
        
        for(int i=0; i<T; i++)
        {
            long N = s.nextLong();
            long K = s.nextLong();
            long M = s.nextLong();
            
            for(long j=0; j<N; j++)
            {
                double temp = K * Math.pow(j+1, 3);
                
                sum = sum + temp;
            }
            
            double required = 0;
            
            if(sum > M)
            {
                required = sum - M;
                
                System.out.println((long)required);
            }
            else
            {
                System.out.println(0);
            }
        }
        
        ObjectOutputStream oo = new ObjectOutputStream(null);

    }
}
