package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for the command that outputs the last 10 commands
 */
public class History implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public History(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде history");
        }
        receiver.History();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда history - команда позволяет увидеть последние 10 выполненных команд.");
    }
}