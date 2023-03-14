package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that deletes all elements of a collection
 */
public class Clear implements command {
    private final Receiver receiver;
    public Clear(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде clear");
        }
        receiver.Clear();
    }

    @Override
    public void Information(){
        System.out.println("Команда clear - удаляет все элементы коллекции.");
    }
}