package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

/**
 * Class for the team that exits the program
 */
public class Exit implements command {
    private final Receiver receiver;
    public Exit(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (args.length > 1){
            System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде exit");
        }
        receiver.Exit();
    }

    @Override
    public void Information(){
        System.out.println("Команда exit - завершение программы.");
    }
}