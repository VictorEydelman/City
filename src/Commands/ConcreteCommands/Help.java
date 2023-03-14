package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that displays a list of available commands
 */
public class Help implements command {
    private final Receiver receiver;
    public Help(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде help");
        }
        receiver.Help();
    }

    @Override
    public void Information(){
        System.out.println("Команда help - получить справку по всем доступным командам.");
    }
}