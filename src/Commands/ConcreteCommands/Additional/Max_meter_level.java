package Commands.ConcreteCommands.Additional;

import Collections.City;

import java.util.Map;

public class Max_meter_level {
    public static int max(Map<Integer, City> map) {
        Long max=0L;
        int key = 0;
        for (Map.Entry<Integer, City> entry : map.entrySet()) {
            if ((entry.getValue().getMetersAboveSeaLevel()) > max) {
                max = entry.getValue().getMetersAboveSeaLevel();
                key=entry.getKey();
            }
        }
        return key;
    }
}
