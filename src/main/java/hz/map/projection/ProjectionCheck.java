package hz.map.projection;

import com.hazelcast.query.SqlPredicate;
import global.AssertionException;
import hz.map.base.MapBench;

import java.util.Collection;
public class ProjectionCheck extends MapBench {

    public int range=10;

    public void timeStep() throws AssertionException {

        int min= random.nextInt(keyDomain - range);
        int max=min+range;

        SqlPredicate sqlPredicate = new SqlPredicate("id >= "+min+" and id < "+max);
        Collection<Integer> ids =  map.project(new IdProjection(), sqlPredicate);

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