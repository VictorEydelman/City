package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

/**
 * Class for a command that outputs the elements of a collection in ascending order
 */
public class PrintAscending implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public PrintAscending(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде print_ascending");
        }
        receiver.PrintAscending();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда print_ascending - выводит элементы коллекции в порядке возрастания.");
    }
}