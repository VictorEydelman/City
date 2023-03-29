package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that displays a list of available commands
 */
public class Help implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Help(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде help");
        }
        receiver.Help();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда help - получить справку по всем доступным командам.");
    }
}