package hz.map.sql.predicate;

import com.hazelcast.core.IMap;
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

        SqlPredicate sqlPredicate = new SqlPredicate("id >= "+min+" and id < "+max);
        Collection<Person> res = map.values(sqlPredicate);

        if(res.size()!=range){
            printPersons(map, res);
            throw new AssertionException(sqlPredicate+" on map "+map.getName()+" returned "+res.size()+" expected "+range);
        }

        for (Person person : res) {
            if(person.getId() < min || person.getId() >= max ){
                printPersons(map, res);
                throw new AssertionException(map.getName()+" "+person+" != "+sqlPredicate);
            }
        }
    }

    private void printPersons(IMap map, Collection<Person> persons){
        System.out.println(map.getName());
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}