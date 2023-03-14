package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that deletes all collection objects whose key is less than the specified one
 */
public class Remove_lower_key_null implements command {
    private final Receiver receiver;
    public Remove_lower_key_null(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 3){
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_lower_key null");
            }
            receiver.Remove_lower(Integer.parseInt(args[2]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда remove_lower_key null - удаление из коллекции всех элементов, ключ которых меньше заданного. Формат ввода: remove_lower_key null key.");
    }
}