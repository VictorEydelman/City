package Commands.ConcreteCommands.Additional;

import Collections.City;

import java.util.Map;

/**
 * Class that finds the key by id
 */
public class id_to_key {
    public static int getKey(Map<Integer, City> map, int arg) {
        int key = -1;
        for (Map.Entry<Integer, City> entry : map.entrySet()) {
            if ((entry.getValue().getid()) == arg) {
                key = entry.getKey();
            }
        }
        return key;
    }
}