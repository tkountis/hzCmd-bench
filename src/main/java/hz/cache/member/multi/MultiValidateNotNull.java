package hz.cache.member.multi;

import global.AssertionException;

public class MultiValidateNotNull extends MultiValidator {

    public void validate(int key, Object value) throws Exception {

        if ( value == null ){
            throw new AssertionException("key "+key+" == "+null);
        }
    }
}