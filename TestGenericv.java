package apackage;

import java.util.HashSet;
import java.util.Set;

public class TestGenericv {
   /* public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }*/
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        return new HashSet<>(s2);
       // result.addAll(s2);
       // return result;
    }
}
