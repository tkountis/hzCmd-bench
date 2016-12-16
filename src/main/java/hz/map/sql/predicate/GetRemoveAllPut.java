package hz.map.sql.predicate;

import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;
import hz.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GetRemoveAllPut extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;
        SqlPredicate sqlPredicate = new SqlPredicate("id >= "+min+" and id < "+max);

        Collection<Person> persons = map.values(sqlPredicate);

        map.removeAll(sqlPredicate);

        Map m = new HashMap<Object, Object>();
        for (Person person : persons) {
            m.put(person.getId(), person);
        }

        map.putAll(map);
    }

}