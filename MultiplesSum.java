import java.util.*;
import java.math.*;

public class MultiplesSum {
    //Solution to HackerRank first ProjectEuler challange
    //had to use BigInt to be able to deal with the large inputs requested

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(multSumOptimized(n));
        }
        
        in.close();
        
    }
    
    public static int multSum(int n){
        //Creates a set to store our resulting set of multiples
        Set<Integer> mult = new HashSet<>();
        
        //multiples of 3
        for(int i=3;i<n;i+=3){
            mult.add(i);
        }
        
        //multiples of 5
        for(int i=5;i<n;i+=5){
            mult.add(i);
        }
        
        int sum =0;
        for(int x:mult){
            sum+=x;
        }
        
        return sum;
    }
    
    public static BigInteger multSumOptimized(int n){
        //we will use Arithmetic progression to obtain the multiples
        //for 3, 5 and we will remove the double counted multiples of 15(counted in 3 5)

        //Sum the values and return it
        return aritSum(n,3).add(aritSum(n,5).subtract(aritSum(n,15))) ;
    }
    
    public static BigInteger aritSum(int n, int base){
        if (n<base){
            return  BigInteger.ZERO;
        }
        int numberTerms = (n-1)/base;

        BigDecimal nBig = BigDecimal.valueOf((double)numberTerms);
        BigDecimal baseBig = BigDecimal.valueOf(base);

        BigDecimal bSum = nBig.subtract(BigDecimal.valueOf(1));
        bSum = bSum.multiply(baseBig);
        bSum = bSum.add(baseBig.multiply(BigDecimal.valueOf(2)));
        bSum = bSum.multiply(nBig.divide(BigDecimal.valueOf(2)));
        

        return bSum.toBigInteger();
    }
}
