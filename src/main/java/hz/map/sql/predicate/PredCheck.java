package hz.map.sql.predicate;

import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;
import hz.model.Person;

import java.util.Set;


public class PredCheck extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;

        SqlPredicate pred = new SqlPredicate("id >= "+min+" and id < "+max);
        Set<Person> res = map.keySet(pred);

        if(res.size()!=range){
            throw new AssertionException("predicate "+pred+" on map "+map.getName()+" returned "+res.size()+" expected "+range);
        }

        for (Person person : res) {
            if(pred.getId() < min || pred.getId() >= max ){
                throw new AssertionException(person+" don't match "+pred);
            }
        }
    }

}