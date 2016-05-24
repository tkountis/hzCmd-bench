package hz.map.predicate;

import com.hazelcast.query.SqlPredicate;
import hz.map.base.MapBench;

import static utils.Utils.randDouble;


public class KeySet extends MapBench {

    public double minSalary=1.0;
    public double maxSalary=1000.0;
    public double range = 10.0;

    public void timeStep() {
        double min = randDouble(random, minSalary, maxSalary);
        double max = min + range;

        map.keySet(new SqlPredicate("salary >= " + min + " and salary <= " + max));
    }

}