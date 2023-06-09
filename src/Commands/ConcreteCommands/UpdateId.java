package Commands.ConcreteCommands;

import Collections.City;
import Commands.Receiver;
import Commands.interfase.Command;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

/**
 * Сlass for the command that updates the collection item
 */
public class UpdateId implements Command {
    private final Receiver receiver;

    /**
     * Method for
     * @param receiver receiver
     */
    public UpdateId(Receiver receiver){
            this.receiver=receiver;
    }

    /**
     * Method execute
     * @param args arg
     * @throws ParseException mistake
     */
    @Override
    public void execute(String[] args) throws ParseException {
        try {
            if (args.length > 2) {
                System.out.println("Введён ненужный аргумент. Команда сведена к базовой команде remove_greater_key null");
            }
            boolean t = false;
            for (Map.Entry<Integer, City> entry : Receiver.getmap().entrySet()) {
                if (entry.getKey().equals(args[1])) {
                    t = true;
                    break;
                }
            }
            if (t) {
                receiver.Update(Integer.parseInt(args[1]));
            } else{
                System.out.println("Введён элемент, которого нет в коллекции.");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Не введён ключ для создания коллекции");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method with information
     */
    @Override
    public void Information(){
        System.out.println("Команда update_id - обновляет элемент коллекции по заданному id. Формат ввода: update_id id");
    }
}