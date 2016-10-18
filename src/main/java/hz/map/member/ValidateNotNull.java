package hz.map.member;

import global.AssertionException;

public class ValidateNotNull extends Validator {

    public void validate(int key, Object value) throws Exception {

        if ( value == null ){
            throw new AssertionException("key == "+null);
        }
    }
}