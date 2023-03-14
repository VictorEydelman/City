package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that deletes a collection item by its key
 */
public class Remove_key_null implements command {
    private final Receiver receiver;
    public Remove_key_null(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length > 3) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_key null.");
            }
            receiver.Remove_key_null(Integer.parseInt(args[2]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда remove_key null - удаление элемента коллекции по его ключу.");
    }
}