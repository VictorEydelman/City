package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

import java.text.ParseException;

/**
 *
 */
public class Insert_null implements command {
    private final Receiver receiver;
    public Insert_null(Receiver receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute(String[] args) throws ParseException {
        try {
            if (args.length > 3) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде insert null");
            }
            receiver.Insert_null(Integer.parseInt(args[2]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда insert null - создаёт новый элемент коллекции. Формат ввода: insert null key");
    }
}