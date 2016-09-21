package hz.map.sql.predicate;

import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;
import hz.model.Person;

import java.util.Collection;


public class PredCheck extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;

        SqlPredicate pred = new SqlPredicate("id >= "+min+" and id < "+max);
        Collection<Person> res = map.values(pred);

        if(res.size()!=range){
            throw new AssertionException(pred+" on map "+map.getName()+" returned "+res.size()+" expected "+range);
        }

        for (Person person : res) {
            if(pred.getId() < min || pred.getId() >= max ){
                throw new AssertionException(map.getName()+" "+person+" != "+pred);
            }
        }
    }

}