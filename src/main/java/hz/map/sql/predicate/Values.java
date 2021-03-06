package hz.map.sql.predicate;

import com.hazelcast.query.SqlPredicate;
import hz.map.sql.predicate.base.PredicateBase;

import static utils.Utils.randDouble;


public class Values extends PredicateBase {

    public void timeStep() {
        double min = randDouble(random, minSalary, maxSalary);
        double max = min + range;

        map.values(new SqlPredicate("salary >= " + min + " and salary <= " + max));
    }

}