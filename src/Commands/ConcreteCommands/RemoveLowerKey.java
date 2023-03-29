package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that deletes all collection objects whose key is less than the specified one
 */
public class RemoveLowerKey implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public RemoveLowerKey(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 2){
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_lower_key null");
            }
            receiver.RemoveLower(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (NumberFormatException ex){
            System.out.println("Введено не число в качестве ключа");
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда remove_lower_key - удаление из коллекции всех элементов, ключ которых меньше заданного. Формат ввода: remove_lower_key null key.");
    }
}