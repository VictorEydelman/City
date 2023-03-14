package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for a command that shows all the elements of a collection
 */
public class Show implements command {
    private final Receiver receiver;
    public Show(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде show");
        }
        receiver.Show();
    }

    @Override
    public void Information(){
        System.out.println("Команда show - вывод всех элементов коллекции.");
    }
}