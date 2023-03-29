package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that deletes all elements of a collection
 */
public class Clear implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Clear(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде clear");
        }
        receiver.Clear();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда clear - удаляет все элементы коллекции.");
    }
}