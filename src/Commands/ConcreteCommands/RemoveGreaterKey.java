package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that deletes all collection objects whose key is greater, than the specified one
 */
public class RemoveGreaterKey implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public RemoveGreaterKey(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            receiver.RemoveGreater(Integer.parseInt(args[1]));
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
        System.out.println("Команда remove_greater_key - удаление из коллекции всех элементов, ключ которых превышает заданный. Формат ввода: remove_greater_key key.");
    }
}