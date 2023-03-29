package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for the team that exits the program
 */
public class Exit implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Exit(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде exit");
        }
        receiver.Exit();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда exit - завершение программы.");
    }
}