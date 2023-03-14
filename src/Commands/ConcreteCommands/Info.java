package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that outputs information about a collection
 */
public class Info implements command {
    private final Receiver receiver;
    public Info(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде info");
        }
        receiver.Info();
    }

    @Override
    public void Information(){
        System.out.println("Команда info - получить информацию по коллекции.");
    }
}