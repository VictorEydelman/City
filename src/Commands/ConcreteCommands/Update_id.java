package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

import java.text.ParseException;

/**
 * Сlass for the command that updates the collection item
 */
public class Update_id implements command {
    private final Receiver receiver;
    public Update_id(Receiver receiver){
            this.receiver=receiver;
    }

    /**
     * @param args
     * @throws ParseException
     */
    @Override
    public void execute(String[] args) throws ParseException {
        try {
            if (args.length > 3) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            receiver.Update_id(Integer.parseInt(args[2]));
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда update_id - обновляет элемент коллекции по заданному id. Формат ввода: update_id id");
    }
}