package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that outputs the elements of a collection in ascending order
 */
public class Print_ascending implements command {
    private final Receiver receiver;
    public Print_ascending(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде print_ascending");
        }
        receiver.Print_ascending();
    }

    @Override
    public void Information(){
        System.out.println("Команда print_ascending - выводит элементы коллекции в порядке возрастания.");
    }
}