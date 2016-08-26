package hz.cache.member;

public class ZeroOut extends Loader {

    @Override
    public Object getValue(int key) {
        return 0;
    }
}