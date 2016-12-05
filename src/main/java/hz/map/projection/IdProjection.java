package hz.map.projection;

import com.hazelcast.projection.Projection;
import hz.model.Person;

import java.util.Map;

public class IdProjection extends Projection<Map.Entry<Integer, Person>, Integer> {

    public Integer transform(Map.Entry<Integer, Person> entry) {

        return entry.getValue().getId();

    }

}