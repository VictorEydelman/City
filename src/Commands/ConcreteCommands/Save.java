package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that saves a collection to a file
 */
public class Save implements command {
    private final Receiver receiver;
    public Save(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде save");
        }
        receiver.Save();
    }

    @Override
    public void Information(){
        System.out.println("Команда save - сохранить коллекцию в файл.");
    }
}