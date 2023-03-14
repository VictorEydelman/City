package Commands.ConcreteCommands.Additional;

import Collections.StandardOfLiving;

import static Collections.StandardOfLiving.*;

/**
 * Class that converts StandardOfLiving to int
 */
public class Standard_to_int {
    /**
     * Method that converts StandardOfLiving to int
     * @param standard
     * @return
     */
    public static int Stand_to_int(StandardOfLiving standard) {
        int number=0;
        switch (standard) {
            case VERY_HIGH:
                number = 5;
                break;
            case HIGH:
                number = 4;
                break;
            case MEDIUM:
                number = 3;
                break;
            case ULTRA_LOW:
                number = 2;
                break;
            case NIGHTMARE:
                number = 1;
                break;
        }
        return number;
    }
}