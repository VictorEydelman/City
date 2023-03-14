package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that outputs a collection item whose metersAboveSeaLevel field value is the maximum
 */
public class Max_by_meters_above_sea_level implements command {
    private final Receiver receiver;
    public Max_by_meters_above_sea_level(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде max_by_meters_above_sea_level");
        }
        receiver.Max_by_meters_above_sea_level();
    }

    @Override
    public void Information(){
        System.out.println("Команда max_by_meters_above_sea_level - вывести любой элемент из коллекции, значение поля metersAboveSeaLevel которого является максимальным.");
    }
}