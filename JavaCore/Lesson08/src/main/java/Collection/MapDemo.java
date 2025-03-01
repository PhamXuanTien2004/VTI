package Collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Hello", 1);
        map.put("こにちは", 2);

        System.out.println("map = " + map);

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry);
        }
    }
}
