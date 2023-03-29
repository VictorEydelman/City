package Commands.ConcreteCommands.Additional;

import Collections.StandardOfLiving;

import static Collections.StandardOfLiving.*;

/**
 * Class that converts StandardOfLiving to int
 */
public class StandardToInt {
    /**
     * Method that converts StandardOfLiving to int
     * @param standard StandardOfLiving
     * @return int
     */
    public static int StandToInt(StandardOfLiving standard) {
        return switch (standard) {
            case VERY_HIGH -> 5;
            case HIGH -> 4;
            case MEDIUM -> 3;
            case ULTRA_LOW -> 2;
            case NIGHTMARE -> 1;
        };
    }
}