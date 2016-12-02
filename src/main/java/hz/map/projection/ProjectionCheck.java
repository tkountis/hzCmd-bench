package hz.map.projection;

import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;
import hz.model.Person;

import java.util.Collection;
import java.util.Map;
public class ProjectionCheck extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;

        SqlPredicate sqlPredicate = new SqlPredicate("id >= "+min+" and id < "+max);
        Collection<Integer> ids = map.project(

                new Projection<Map.Entry<Integer, Person>, Integer>() {

                    public Integer transform(Map.Entry<Integer, Person> entry) {
                         return entry.getValue().getId();
                    }
                },
                sqlPredicate);

        if(ids.size()!=range){
            throw new AssertionException(sqlPredicate+" on map "+map.getName()+" returned "+ids.size()+" expected "+range);
        }

        for (int id : ids) {
            if(id < min || id >= max ){
                throw new AssertionException(sqlPredicate+" on map "+map.getName()+" "+id+" != "+sqlPredicate);
            }
        }
    }
}