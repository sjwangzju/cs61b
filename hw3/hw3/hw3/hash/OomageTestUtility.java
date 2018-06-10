package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int[] array = new int[M];
        int bucketNum;
        for(Oomage o : oomages){
            bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            array[bucketNum] += 1;
        }
        for(int n : array){
            if(n < oomages.size() / 50 || n > oomages.size() / 2.5) return false;
        }
        return true;
    }
}
