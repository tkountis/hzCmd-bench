package hz.map.member.multi;

public class MultiLoad extends MultiLoader {

    @Override
    public Object getValue(int key) {
        return  mapKeyToValue(key);
    }
}