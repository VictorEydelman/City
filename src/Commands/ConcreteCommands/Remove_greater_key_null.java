package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that deletes all collection objects whose key is greater, than the specified one
 */
public class Remove_greater_key_null implements command {
    private final Receiver receiver;
    public Remove_greater_key_null(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 3) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            receiver.Remove_greater(Integer.parseInt(args[2]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда remove_greater_key null - удаление из коллекции всех элементов, ключ которых превышает заданный. Формат ввода: remove_greater_key null key.");
    }
}