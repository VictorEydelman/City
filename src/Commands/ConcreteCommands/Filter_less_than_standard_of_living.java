package Commands.ConcreteCommands;

import Collections.StandardOfLiving;
import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that outputs all elements of a collection whose standardOfLiving field value is less than the specified one
 */
public class Filter_less_than_standard_of_living implements command {
    private final Receiver receiver;
    public Filter_less_than_standard_of_living(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args) {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде filter_less_than_standard_of_living");
            }
            receiver.Filter_less_than_standard_of_living(StandardOfLiving.valueOf(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда filter_less_than_standard_of_living - она выводит элементы, значение поля standardOfLiving которых меньше заданного." +
                "Формат ввода: filter_less_than_standard_of_living standardOfLiving(VERY-HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE");
    }
}