package Commands.ConcreteCommands;

import Collections.StandardOfLiving;
import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that outputs all elements of a collection whose standardOfLiving field value is less than the specified one
 */
public class FilterStandardOfLiving implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public FilterStandardOfLiving(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args) {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде filter_less_than_standard_of_living");
            }
            receiver.FilterStandardOfLiving(StandardOfLiving.valueOf(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Не введён ключ для создания коллекции");
        } catch (IllegalArgumentException ex){
            System.out.println("Введён не правильное значение StandardOfLiving");
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда filter_less_than_standard_of_living - она выводит элементы, значение поля standardOfLiving которых меньше заданного." +
                "Формат ввода: filter_less_than_standard_of_living standardOfLiving(VERY-HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE");
    }
}