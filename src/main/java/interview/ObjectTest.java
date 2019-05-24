package interview;

import java.util.HashMap;
import java.util.Hashtable;

public class ObjectTest {

    public static void main(String[] args) {
        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));

        HashMap map = new HashMap();
        map.put(null, null);

        Hashtable hashtable = new Hashtable();
        hashtable.put(null, null);
    }
}
