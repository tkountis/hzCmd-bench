package hz.set;

import com.hazelcast.core.ISet;
import global.AssertionException;
import hz.set.base.SetBench;

import java.util.HashSet;
import java.util.Set;

public class SetAssert extends SetBench {

    public int size=0;

    public void timeStep() throws AssertionException{

        for (ISet set : sets) {

            Set<Integer> duplicates = findDuplicates(set);

            if (!duplicates.isEmpty()) {
                throw new AssertionException("set " + set.getName() + " has duplicates " + duplicates);
            }

            if (set.size() != size) {
                throw new AssertionException("set " + set.getName() + " size " + set.size() + " != " + size);
            }
        }

        setRunning(false);
    }


    public Set<Integer> findDuplicates(Set<Integer> set)
    {
        final Set<Integer> duplicates = new HashSet();
        final Set<Integer> test = new HashSet();

        for (Integer i : set) {
            if (!test.add(i)) {
                duplicates.add(i);
            }
        }
        return duplicates;
    }

}