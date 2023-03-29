package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that outputs a collection item whose metersAboveSeaLevel field value is the maximum
 */
public class MaxMeters implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public MaxMeters(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде max_by_meters_above_sea_level");
        }
        receiver.MaxMeters();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда max_by_meters_above_sea_level - вывести любой элемент из коллекции, значение поля metersAboveSeaLevel которого является максимальным.");
    }
}