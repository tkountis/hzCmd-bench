package utils;

import com.hazelcast.cache.ICache;
import com.hazelcast.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Utils {

    public static List<byte[]> dymanicValues(int setSize, int middleSize){
        Random random = new Random();
        List valueSet = new ArrayList(setSize);

        int min = middleSize / 2;
        int max = middleSize + min;


        return dymanicValues(setSize, min, max);
    }

    public static List<byte[]> dymanicValues(int setSize, int min, int max){
        Random random = new Random();
        List valueSet = new ArrayList(setSize);

        if(setSize==1){
            byte[] value = new byte[min+max/2];
            random.nextBytes(value);
            valueSet.add(value);
            return valueSet;
        }

        for(int i=0; i<setSize; i++){
            int sz = randInt(random, min, max);
            byte[] value = new byte[sz];
            random.nextBytes(value);
            valueSet.add(value);
        }
        return valueSet;
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min inclusive and max, ex-inclusive.
     * @see Random#nextInt(int)
     */
    public static int randInt(Random random, int min, int max) {
        int randomNum = random.nextInt( max-min ) + min;
        return randomNum;
    }
}
