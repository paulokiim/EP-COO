import java.util.*;
import java.lang.*;

public class Box {

    public static void main (String args[]) {
        //TreeMap -> para fornecer os nomes em ordem alfabetica
        //LinkedHashMap -> para fornecer os nomes em que foram inseridas
        Map<String, Integer> m = new TreeMap <String, Integer> ();

        for (String a : args) {
            Integer freq = m.get(a);
            m.put (a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println (m.size() + " palavras distintas\n");
        System.out.println (m);
    }
}