package hz.map.sql.predicate;

import com.hazelcast.core.IMap;
import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;
import hz.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GetRemovePut extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;

        SqlPredicate sqlPredicate = new SqlPredicate("id >= "+min+" and id < "+max);

        Collection<Person> persons = map.values(sqlPredicate);
        map.removeAll(sqlPredicate);

        for (Person person : persons) {
            if(person.getId() < min || person.getId() >= max ){
                printPersons(sqlPredicate, map, persons, range);
                throw new AssertionException(map.getName()+" "+person+" != "+sqlPredicate);
            }
        }

        Map m = new HashMap<Object, Object>();
        for (Person person : persons) {
            m.put(person.getId(), person);
        }

        map.putAll(map);
    }

    private void printPersons(SqlPredicate predicate, IMap map, Collection<Person> persons, int expectedSize){
        int ref = random.nextInt(10000000);
        System.out.println("ref("+ref+") "+predicate+" on map "+map.getName()+" size="+persons.size()+" expected="+expectedSize);
        for (Person person : persons) {
            System.out.println("ref("+ref+") "+person);
        }
    }
}