package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.Command;

import java.text.ParseException;

/**
 * Class for a command that shows all the elements of a collection
 */
public class Show implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public Show(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде show");
        }
        receiver.Show();
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда show - вывод всех элементов коллекции.");
    }
}